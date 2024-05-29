package com.zwg.service;


import com.zwg.model.NlpDTO;
import com.zwg.model.NlpRequest;
import reactor.core.publisher.Flux;

public interface NlpService {
    /**
     * 得到语义解析结果
     */
    Flux<NlpDTO> nlp(NlpRequest nlpRequest);
}
