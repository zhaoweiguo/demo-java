package com.zwg.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class NlpRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cmd;
    private String vdm;

    private String lenovoId;
    private String lenovoName;
}
