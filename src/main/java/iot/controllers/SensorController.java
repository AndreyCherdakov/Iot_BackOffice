package main.java.iot.controllers;

import main.java.iot.domain.SensorDto;
import main.java.iot.services.ISensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController(value = "SensorController")
//@CrossOrigin
@RequestMapping(value = IEndPoints.SENSOR_CONTROLLER)
public class SensorController {

    @Autowired
    @Qualifier(value = "SensorService")
    private ISensorService sensService;

    @GetMapping(value = IEndPoints.SENSOR_GET_BY_ID)
    public List<SensorDto> getSensorsByIdAndTimestampBetween(@RequestParam int sensorId,
                                      @RequestParam String from,
                                      @RequestParam String to) {
        return sensService.getSensorsByIdAndTimestamp(sensorId, LocalDateTime.parse(from), LocalDateTime.parse(to));
    }

    @GetMapping(value = IEndPoints.SENSOR_GET_ALL_ID)
    public List<SensorDto> getAllSensorsById(@RequestParam int sensorId) {
        return sensService.getAllSensorsById(sensorId);
    }

    @GetMapping(value = IEndPoints.SENSOR_GET_BY_TYPE)
    public List<SensorDto> getSensorsByTypeAndTimestampBetween(@RequestParam String sensorType,
                                      @RequestParam String from,
                                      @RequestParam String to) {
        return sensService.getSensorsBySensorTypeAndTimestamp(sensorType, LocalDateTime.parse(from), LocalDateTime.parse(to));
    }

    @GetMapping(value = IEndPoints.SENSOR_GET_TIMESTAMP)
    public List<LocalDateTime> getLocalDateTimeByIdAndValues(@RequestParam int sensorId,
                                          @RequestParam double[] value){
        return sensService.getTimestampBySensorIdAndSensorValue(sensorId, value);
    }
}
