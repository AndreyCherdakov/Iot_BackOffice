package main.java.iot.mapper;

import main.java.iot.domain.SensorNormallyValuesDto;
import main.java.iot.entities.SensorNormallyValuesEntity;

public class SensorNormallyValueMapper extends AbstractMapper<SensorNormallyValuesEntity, SensorNormallyValuesDto> {

    public SensorNormallyValueMapper(Class<SensorNormallyValuesEntity> entityClass, Class<SensorNormallyValuesDto> dtoClass) {
        super(entityClass, dtoClass);
    }

}
