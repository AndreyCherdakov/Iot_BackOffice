package main.java.iot.mapper;

import main.java.iot.domain.SensorDto;
import main.java.iot.entities.SensorEntity;

public class SensorMapper extends AbstractMapper<SensorEntity, SensorDto> {

    public SensorMapper(Class<SensorEntity> entityClass, Class<SensorDto> dtoClass) {
        super(entityClass, dtoClass);
    }
}
