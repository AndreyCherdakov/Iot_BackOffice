package main.java.iot.mapper;

import main.java.iot.domain.SensorContactsDto;
import main.java.iot.entities.SensorContactsEntity;

public class SensorContactsMapper extends AbstractMapper<SensorContactsEntity, SensorContactsDto> {

    public SensorContactsMapper(Class<SensorContactsEntity> entityClass, Class<SensorContactsDto> dtoClass) {
        super(entityClass, dtoClass);
    }
}
