package com.zwg.service;


import com.zwg.model.NlpDTO;
import com.zwg.model.NlpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class NlpServiceImpl implements NlpService {

    @Override
    public Flux<NlpDTO> nlp(NlpRequest nlpRequest) {
        return Flux.just(new NlpDTO()
                .setFocus(nlpRequest.getCmd())
                .setOperation(nlpRequest.getVdm())
        );
    }
}
