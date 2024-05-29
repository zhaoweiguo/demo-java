package com.zwg.model;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NlpDTO {
    private String focus;

    private String queryText;
}
