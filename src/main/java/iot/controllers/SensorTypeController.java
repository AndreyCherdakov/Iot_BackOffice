package main.java.iot.controllers;

import main.java.iot.domain.SensorContactsDto;
import main.java.iot.domain.SensorMapperDto;
import main.java.iot.domain.SensorNormallyValuesDto;
import main.java.iot.domain.SensorTypeDto;
import main.java.iot.enumirations.SensorActions;
import main.java.iot.enumirations.SensorOperations;
import main.java.iot.enumirations.SensorTypes;
import main.java.iot.services.ISensorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "SensorTypeController")
@RequestMapping(value = IEndPoints.TYPE_CONTROLLER)
public class SensorTypeController {

    @Autowired
    @Qualifier(value = "SensorTypeService")
    private ISensorTypeService sensTypeService;

    @PostMapping(value = IEndPoints.TYPE_ADD_SENSOR)
    public HttpStatus addSensorType(@RequestBody SensorTypeDto sensorTypeDto) {
        return sensTypeService.addSensor(sensorTypeDto);
    }

    @DeleteMapping(value = IEndPoints.TYPE_REMOVE_SENSOR)
    public HttpStatus rmvSensor(@RequestParam int sensorId) {
        return sensTypeService.rmvSensor(sensorId);
    }

    @GetMapping(value = IEndPoints.ENUM_ACTIONS)
    public List<SensorActions> getSensorActions() {
        return sensTypeService.getEnumSensorActions();
    }

    @GetMapping(value = IEndPoints.ENUM_OPERATIONS)
    public List<SensorOperations> getSensorOperations() {
        return sensTypeService.getEnumSensorOperations();
    }

    @GetMapping(value = IEndPoints.ENUM_TYPES)
    public List<SensorTypes> getSensorTypes() {
        return sensTypeService.getEnumSensorTypes();
    }

    @GetMapping(value = IEndPoints.TYPE_GET_SENSOR)
    public SensorTypeDto getSensorType(@RequestParam int sensorId) {
        return sensTypeService.getSensorType(sensorId);
    }

    @PutMapping(value = IEndPoints.TYPE_UPD_NAME)
    public HttpStatus updName(@RequestParam int sensorId,
                              @RequestParam String name) {
        return sensTypeService.updSensorName(sensorId, name);
    }

    @PutMapping(value = IEndPoints.TYPE_UPD_LOC)
    public HttpStatus updLoc(@RequestParam int sensorId,
                              @RequestParam String location) {
        return sensTypeService.updSensorName(sensorId, location);
    }

    @PutMapping(value = IEndPoints.TYPE_UPD_MAPPER)
    public HttpStatus updMapper(@RequestParam int sensorId,
                                @RequestBody SensorMapperDto sensorMapperDto) {
        return sensTypeService.updSensorMapper(sensorId, sensorMapperDto);
    }

    @PutMapping(value = IEndPoints.TYPE_UPD_CONTACTS)
    public HttpStatus updContacts(@RequestParam int sensorId,
                                  @RequestBody SensorContactsDto sensorContactsDto) {
        return sensTypeService.updSensorContacts(sensorId, sensorContactsDto);
    }

    @PutMapping(value = IEndPoints.TYPE_UPD_VALUES)
    public HttpStatus updValues(@RequestParam int sensorId,
                                @RequestBody SensorNormallyValuesDto sensorNormallyValuesDto) {
        return sensTypeService.updSensorNormallyValues(sensorId, sensorNormallyValuesDto);
    }

}
