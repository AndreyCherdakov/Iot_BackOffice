package main.java.iot.services;

import main.java.iot.domain.*;
import main.java.iot.enumirations.SensorActions;
import main.java.iot.enumirations.SensorOperations;
import main.java.iot.enumirations.SensorTypes;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ISensorTypeService {

    /*  ADD  */
    public HttpStatus addSensor(SensorTypeDto sensorTypeDto);
    public HttpStatus addMapper(SensorMapperDto sensorMapperDto);
    public HttpStatus addContacts(SensorContactsDto sensorContactsDto);
    public HttpStatus addNormallyValues(SensorNormallyValuesDto sensorNormallyValuesDto);
    /*  REMOVE  */
    public HttpStatus rmvSensor(int sensorId);
    public HttpStatus rmvMapper(int sensorId);
    public HttpStatus rmvContacts(int sensorId);
    public HttpStatus rmvNormallyValues(int sensorId);
    /*  GET  */
    public List<SensorTypes> getEnumSensorTypes();
    public List<SensorActions> getEnumSensorActions();
    public List<SensorOperations> getEnumSensorOperations();
    public SensorTypeDto getSensorType(int sensorId);
    public List<ActionsLogDto> getActionLog(int sensorId);
    /*  UPDATE  */
    public HttpStatus updSensorLocation(int sensorId, String newLocation);
    public HttpStatus updSensorName(int sensorId, String newName);
    public HttpStatus updSensorMapper(int sensorId, SensorMapperDto newMapper);
    public HttpStatus updSensorContacts(int sensorId, SensorContactsDto newContacts);
    public HttpStatus updSensorNormallyValues(int sensorId, SensorNormallyValuesDto newValues);
}
