package com.zwg.req;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class NlpRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cmd;
}
