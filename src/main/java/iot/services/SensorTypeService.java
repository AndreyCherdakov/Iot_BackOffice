package main.java.iot.services;

import main.java.iot.domain.*;
import main.java.iot.entities.*;
import main.java.iot.enumirations.SensorActions;
import main.java.iot.enumirations.SensorOperations;
import main.java.iot.enumirations.SensorTypes;
import main.java.iot.mapper.IMapper;
import main.java.iot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service(value = "SensorTypeService")
public class SensorTypeService implements ISensorTypeService{

    /*  VARIABLES  */

    /* REPOSITORIES */
    @Autowired
    @Qualifier(value = "SensorTypeRepository")
    private SensorTypeRepository sensTypeRepo;

    @Autowired
    @Qualifier(value = "ActionsLogRepository")
    private ActionsLogRepository actionsLogRepo;

    @Autowired
    @Qualifier(value = "SensorContactsRepository")
    private SensorContactsRepository sensContactsRepo;

    @Autowired
    @Qualifier(value = "SensorMapperRepository")
    private SensorMapperRepository sensMapperRepo;

    @Autowired
    @Qualifier(value = "SensorNormallyValuesRepository")
    private SensorNormallyValuesRepository sensNormallyValuesRepo;

    /*  MAPPERS  */

    @Autowired
    @Qualifier(value = "MapperSensorMapper")
    private IMapper<SensorMapperEntity, SensorMapperDto> mapMapper;

    @Autowired
    @Qualifier(value = "MapperSensorContacts")
    private IMapper<SensorContactsEntity, SensorContactsDto> mapContacts;

    @Autowired
    @Qualifier(value = "MapperSensorNormallyValue")
    private IMapper<SensorNormallyValuesEntity, SensorNormallyValuesDto> mapNormallyValue;

    @Autowired
    @Qualifier(value = "MapperSensorType")
    private IMapper<SensorTypeEntity, SensorTypeDto> mapSensorType;

    /*  ==========================================================  */

    @Override
    public HttpStatus addSensor(SensorTypeDto sensorTypeDto) {
        SensorTypeEntity sensorTypeEntity = sensTypeRepo.findBySensorId(sensorTypeDto.getSensorId());
        if (!Objects.isNull(sensorTypeEntity)) {
            return HttpStatus.FOUND;
        }
        HttpStatus status = addMapper(sensorTypeDto.getSensorMapperDto());
        if (!status.equals(HttpStatus.OK)) {
            return status;
        }
        status = addContacts(sensorTypeDto.getSensorContactsDto());
        if (!status.equals(HttpStatus.OK)) {
            return status;
        }
        status = addNormallyValues(sensorTypeDto.getSensorNormallyValuesDto());
        if (!status.equals(HttpStatus.OK)) {
            return status;
        }
        sensTypeRepo.save(mapSensorType.dtoToEntity(sensorTypeDto));
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus addMapper(SensorMapperDto sensorMapperDto) {
        SensorMapperEntity sensMapperEntity = sensMapperRepo.findBySensorId(sensorMapperDto.getSensorId());
        if (!Objects.isNull(sensMapperEntity)) {
            return HttpStatus.FOUND;
        }
        sensMapperRepo.save(mapMapper.dtoToEntity(sensorMapperDto));
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus addContacts(SensorContactsDto sensorContactsDto) {
        SensorContactsEntity sensContactsEntity = sensContactsRepo.findBySensorId(sensorContactsDto.getSensorId());
        if (!Objects.isNull(sensContactsEntity)) {
            return HttpStatus.FOUND;
        }
        sensContactsRepo.save(mapContacts.dtoToEntity(sensorContactsDto));
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus addNormallyValues(SensorNormallyValuesDto sensorNormallyValuesDto) {
        SensorNormallyValuesEntity sensNormallyValueEntity = sensNormallyValuesRepo.findBySensorId(sensorNormallyValuesDto.getSensorId());
        if (!Objects.isNull(sensNormallyValueEntity)) {
            return HttpStatus.FOUND;
        }
        sensNormallyValuesRepo.save(mapNormallyValue.dtoToEntity(sensorNormallyValuesDto));
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus rmvSensor(int sensorId) {
        SensorTypeEntity sensorTypeEntity = sensTypeRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorTypeEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        HttpStatus status = rmvMapper(sensorId);
        if (!status.equals(HttpStatus.OK)) {
            return status;
        }
        status = rmvContacts(sensorId);
        if (!status.equals(HttpStatus.OK)) {
            return status;
        }
        status = rmvNormallyValues(sensorId);
        if (!status.equals(HttpStatus.OK)) {
            return status;
        }
        sensTypeRepo.delete(sensorTypeEntity);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus rmvMapper(int sensorId) {
        SensorMapperEntity sensorMapperEntity = sensMapperRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorMapperEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        sensMapperRepo.delete(sensorMapperEntity);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus rmvContacts(int sensorId) {
        SensorContactsEntity sensorContactsEntity = sensContactsRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorContactsEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        sensContactsRepo.delete(sensorContactsEntity);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus rmvNormallyValues(int sensorId) {
        SensorNormallyValuesEntity sensorNormallyValuesEntity = sensNormallyValuesRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorNormallyValuesEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        sensNormallyValuesRepo.delete(sensorNormallyValuesEntity);
        return HttpStatus.OK;
    }

    @Override
    public List<SensorTypes> getEnumSensorTypes() {
        return new ArrayList<>(Arrays.asList(SensorTypes.values()));
    }

    @Override
    public List<SensorActions> getEnumSensorActions() {
        return new ArrayList<>(Arrays.asList(SensorActions.values()));
    }

    @Override
    public List<SensorOperations> getEnumSensorOperations() {
        return new ArrayList<>(Arrays.asList(SensorOperations.values()));
    }

    @Override
    public SensorTypeDto getSensorType(int sensorId) {
        SensorTypeEntity sensorTypeEntity = sensTypeRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorTypeEntity)) {
            return new SensorTypeDto();
        }
        return mapSensorType.entityToDto(sensorTypeEntity);
    }

    @Override
    public List<ActionsLogDto> getActionLog(int sensorId) {
        return null;
    }

    @Override
    public HttpStatus updSensorLocation(int sensorId, String newLocation) {
        SensorTypeEntity sensorTypeEntity = sensTypeRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorTypeEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        if (newLocation.length() == 0) {
            return HttpStatus.NO_CONTENT;
        }
        sensorTypeEntity.setSensorLocation(newLocation);
        sensTypeRepo.save(sensorTypeEntity);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updSensorName(int sensorId, String newName) {
        SensorTypeEntity sensorTypeEntity = sensTypeRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorTypeEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        if (newName.length() == 0) {
            return HttpStatus.NO_CONTENT;
        }
        sensorTypeEntity.setSensorName(newName);
        sensTypeRepo.save(sensorTypeEntity);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updSensorMapper(int sensorId, SensorMapperDto newMapper) {
        SensorMapperEntity sensorMapperEntity = sensMapperRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorMapperEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        SensorMapperEntity newSensorMapperEntity = mapMapper.dtoToEntity(newMapper);
        if (Objects.isNull(newSensorMapperEntity)) {
            return HttpStatus.NO_CONTENT;
        }
        newSensorMapperEntity.setObjectId(sensorMapperEntity.getObjectId());
        sensMapperRepo.save(newSensorMapperEntity);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updSensorContacts(int sensorId, SensorContactsDto newContacts) {
        SensorContactsEntity sensorContactsEntity = sensContactsRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorContactsEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        SensorContactsEntity newSensorContactsEntity = mapContacts.dtoToEntity(newContacts);
        if (Objects.isNull(newSensorContactsEntity)) {
            return HttpStatus.NO_CONTENT;
        }
        newSensorContactsEntity.setObjectId(sensorContactsEntity.getObjectId());
        sensContactsRepo.save(newSensorContactsEntity);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updSensorNormallyValues(int sensorId, SensorNormallyValuesDto newValues) {
        SensorNormallyValuesEntity sensorNormallyValuesEntity = sensNormallyValuesRepo.findBySensorId(sensorId);
        if (Objects.isNull(sensorNormallyValuesEntity)) {
            return HttpStatus.NOT_FOUND;
        }
        SensorNormallyValuesEntity newSensorNormallyValuesEntity = mapNormallyValue.dtoToEntity(newValues);
        if (Objects.isNull(newSensorNormallyValuesEntity)) {
            return HttpStatus.NO_CONTENT;
        }
        newSensorNormallyValuesEntity.setObjectId(sensorNormallyValuesEntity.getObjectId());
        sensNormallyValuesRepo.save(newSensorNormallyValuesEntity);
        return HttpStatus.OK;
    }
}
