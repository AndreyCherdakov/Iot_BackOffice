package main.java.iot.configs;

import main.java.iot.domain.*;
import main.java.iot.entities.*;
import main.java.iot.mapper.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MapperCfg {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ModelMapper modelMapperCfg() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);
        return modelMapper;
    }

    @Bean(value = "MapperSensor")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IMapper<SensorEntity, SensorDto> sensorMapper() {
        return new SensorMapper(SensorEntity.class, SensorDto.class);
    }

    @Bean(value = "MapperSensorMapper")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IMapper<SensorMapperEntity, SensorMapperDto> sensorMapperMapper() {
        return new SensorMapperMapper(SensorMapperEntity.class, SensorMapperDto.class);
    }

    @Bean(value = "MapperSensorContacts")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IMapper<SensorContactsEntity, SensorContactsDto> sensorContactsMapper() {
        return new SensorContactsMapper(SensorContactsEntity.class, SensorContactsDto.class);
    }

    @Bean(value = "MapperSensorNormallyValue")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IMapper<SensorNormallyValuesEntity, SensorNormallyValuesDto> sensorNormallyValueMapper() {
        return new SensorNormallyValueMapper(SensorNormallyValuesEntity.class, SensorNormallyValuesDto.class);
    }

    @Bean(value = "MapperSensorType")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IMapper<SensorTypeEntity, SensorTypeDto> sensorTypeMapper() {
        return new SensorTypeMapper(SensorTypeEntity.class, SensorTypeDto.class);
    }

}
