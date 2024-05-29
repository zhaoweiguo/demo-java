package com.zwg.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NlpDTO {
    private String focus;
    private String subFocus;
    private String operation;
    private Object extras;
    private Object object;
    private Object engine;
    private Object engineResponse;

    private String queryText;
    private String dataUnionId;
}
