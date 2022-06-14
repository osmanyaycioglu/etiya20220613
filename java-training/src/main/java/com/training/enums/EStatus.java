package com.training.enums;

public enum EStatus {
    RUNNING("running state",
            100),
    STOPPED("stopped state",
            101) {
        @Override
        public String getLongDescription() {
            return "Bu farklı bir desc " + getDesc() + " code : " + getCode();
        }
    },
    SUPENDED("suspended state",
             102);

    private final String desc;
    private final int code;

    private EStatus(String desc,
                    int code) {

        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

    public String getLongDescription(){
        return code + " lu status : " + desc;
    }
}


