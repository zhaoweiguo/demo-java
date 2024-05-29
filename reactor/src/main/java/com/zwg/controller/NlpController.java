package com.zwg.controller;


import com.zwg.model.NlpDTO;
import com.zwg.model.NlpRequest;
import com.zwg.service.NlpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@RestController
public class NlpController {
    private final NlpService nlpService;

    @PostMapping(value = "/api/v1/nlp")
    public NlpDTO nlp(@RequestBody NlpRequest request) {
        return nlpStream(request).blockFirst(Duration.ofSeconds(10));
    }

    @PostMapping(value = "/api/v1/nlp/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NlpDTO> nlpStream(@RequestBody NlpRequest request) {
//        check(request);
        return nlpService.nlp(request);
    }

}
