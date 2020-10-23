package com.demo.aop.app.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This enum is used by {@link MeasureTime}
 */
@AllArgsConstructor
@Getter
public enum MeasureEnum {
    MILLIS(0, "ms"), NANOS(1, "n"), SECONDS(2, "sec");

    private final int type;

    private final String abbreviation;

}
