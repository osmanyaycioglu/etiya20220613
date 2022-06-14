package com.training.enums;

public enum ETimeUnit2 {

    SECONDS() {
        public long getMilis(long valueParam) {
            return 1000L * valueParam;
        }
    },
    MINUTES() {
        public long getMilis(long valueParam) {
            return 60 * SECONDS.getMilis(valueParam);
        }
    },
    HOURS() {
        public long getMilis(long valueParam) {
            return 60 * MINUTES.getMilis(valueParam);
        }
    },
    DAYS() {
        public long getMilis(long valueParam) {
            return 24 * HOURS.getMilis(valueParam);
        }
    },
    YEARS() {
        public long getMilis(long valueParam) {
            return 365 * DAYS.getMilis(valueParam);
        }
    },
    ;

    public long getMilis(long valueParam) {
        return valueParam;
    }
}
