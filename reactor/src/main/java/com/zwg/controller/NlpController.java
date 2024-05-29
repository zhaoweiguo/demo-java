package com.zwg.controller;


import com.zwg.aggr.NlpAggr;
import com.zwg.gateway.NlpEngineGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.zwg.model.NlpDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import com.zwg.req.NlpRequest;

import java.time.Duration;
import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
public class NlpController {
    private final List<NlpEngineGateway> nlpEngineGateways;
    @PostMapping(value = "/api/v1/nlp")
    public NlpDTO nlp(@RequestBody NlpRequest request) {
        return nlpStream(request).blockFirst(Duration.ofSeconds(10));
    }

    @PostMapping(value = "/api/v1/nlp/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NlpDTO> nlpStream(@RequestBody NlpRequest request) {

        return Optional.of(new NlpAggr(request))
                .map(aggr -> aggr.processOn(nlpEngineGateways))
                .map(NlpAggr::getResult)
                .orElse(null);
    }

}
