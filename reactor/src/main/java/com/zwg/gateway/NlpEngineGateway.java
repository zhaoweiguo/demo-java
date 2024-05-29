package com.zwg.gateway;

import com.zwg.aggr.EngineType;
import com.zwg.aggr.NlpAggr;
import com.zwg.model.NlpDTO;
import reactor.core.publisher.Flux;
import com.zwg.req.NlpRequest;

public interface NlpEngineGateway {
    EngineType getEngineType();

    default NlpDTO createDTO(NlpRequest request, Object engineResponse) {
        return new NlpDTO()
            .setQueryText(request.getCmd());
    }

    Flux<NlpDTO> process(NlpAggr nlpAggr);
}
