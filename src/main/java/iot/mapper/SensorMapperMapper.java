package main.java.iot.mapper;

import main.java.iot.domain.SensorMapperDto;
import main.java.iot.entities.SensorMapperEntity;

public class SensorMapperMapper extends AbstractMapper<SensorMapperEntity, SensorMapperDto> {

    public SensorMapperMapper(Class<SensorMapperEntity> entityClass, Class<SensorMapperDto> dtoClass) {
        super(entityClass, dtoClass);
    }
}
