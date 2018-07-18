package com.mytaxi.domainvalue;


public enum EngineType {

    ELECTRICAL("ELEC"),
    GASOLINE("GASOLINE"),
    HIBRID("HIB");

    private final String code;

    EngineType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
