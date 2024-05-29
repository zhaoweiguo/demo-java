package com.zwg.aggr;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum EngineType {
    SYSCMD("syscmd"),
    AIML("aiml"),
    TREND("trend"),
    PLUGIN("plugin"),
    INTEND("intend"),
    UNKNOWN("");
    private final String value;

    public static EngineType of(String engine) {
        return Arrays.stream(values())
            .filter(e -> Objects.equals(e.value, engine))
            .findFirst()
            .orElse(UNKNOWN);
    }
}

