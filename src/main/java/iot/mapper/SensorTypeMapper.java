package main.java.iot.mapper;

import main.java.iot.domain.SensorTypeDto;
import main.java.iot.entities.SensorTypeEntity;

public class SensorTypeMapper extends AbstractMapper<SensorTypeEntity, SensorTypeDto> {

    public SensorTypeMapper(Class<SensorTypeEntity> entityClass, Class<SensorTypeDto> dtoClass) {
        super(entityClass, dtoClass);
    }

}
