package main.java.iot.services;

import main.java.iot.domain.SensorDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ISensorService {

    public List<SensorDto> getSensorsByIdAndTimestamp(int sensorId, LocalDateTime from, LocalDateTime to);
    public List<SensorDto> getAllSensorsById(int sensorId);
    public List<SensorDto> getSensorsBySensorTypeAndTimestamp(String sensorType, LocalDateTime from, LocalDateTime to);
    public List<LocalDateTime> getTimestampBySensorIdAndSensorValue(int sensorId, double[] value);

}
