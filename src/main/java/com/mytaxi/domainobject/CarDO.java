package com.mytaxi.domainobject;

import com.mytaxi.util.EngineType;

import java.time.ZonedDateTime;


public class CarDO {

    private Long id;
    private ZonedDateTime date_created;
    private String licence_plate;
    private Integer seat_count;
    private Boolean convertible;
    private Integer rating;
    private Enum<EngineType> engine_type;
}
