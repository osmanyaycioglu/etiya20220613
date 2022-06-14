package com.training.enums;

public enum ETimeUnit1 {

    SECONDS(1_000L),
    MINUTES(60 * 1000L),
    HOURS(60 * 60 * 1000L),
    DAYS(24 * 60 * 60 * 1000L),
    YEARS(365 * 24 * 60 * 60 * 1000L);
    private long value;

    private ETimeUnit1(long value) {
        this.value = value;
    }

    public long getMilis(long valueParam) {
        return value * valueParam;
    }
}
