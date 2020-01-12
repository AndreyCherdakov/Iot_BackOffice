package main.java.iot.services;

import main.java.iot.domain.SensorDto;
import main.java.iot.entities.SensorEntity;
import main.java.iot.mapper.IMapper;
import main.java.iot.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service(value = "SensorService")
public class SensorService implements ISensorService {

    @Autowired
    @Qualifier(value = "SensorRepository")
    private SensorRepository sensRepo;

    @Autowired
    @Qualifier(value = "MapperSensor")
    private IMapper<SensorEntity, SensorDto> sensMapper;

    @Override
    public List<SensorDto> getSensorsByIdAndTimestamp(int sensorId, LocalDateTime from, LocalDateTime to) {

        List<SensorEntity> sensorEntity = sensRepo.findBySensorIdAndTimestampBetween(sensorId, getMillis(from), getMillis(to));
        if (Objects.isNull(sensorEntity) || sensorEntity.isEmpty()) {
            return new ArrayList<>();
        }
        return sensorEntity.stream().map(entry -> sensMapper.entityToDto(entry)).collect(Collectors.toList());
    }

    @Override
    public List<SensorDto> getAllSensorsById(int sensorId) {
        List<SensorEntity> lstSensors = sensRepo.findAllBySensorId(sensorId);
        if (Objects.isNull(lstSensors) || lstSensors.isEmpty()) {
            return new ArrayList<>();
        }
        return lstSensors.stream().map(entry -> sensMapper.entityToDto(entry)).collect(Collectors.toList());
    }

    @Override
    public List<SensorDto> getSensorsBySensorTypeAndTimestamp(String sensorType, LocalDateTime from, LocalDateTime to) {
        List<SensorEntity> sensorEntity = sensRepo.findBySensorTypeAndTimestampBetween(sensorType, getMillis(from), getMillis(to));
        if (Objects.isNull(sensorEntity) || sensorEntity.isEmpty()) {
            return new ArrayList<>();
        }
        return sensorEntity.stream().map(entry -> sensMapper.entityToDto(entry)).collect(Collectors.toList());
    }

    @Override
    public List<LocalDateTime> getTimestampBySensorIdAndSensorValue(int sensorId, double[] value) {
        List<Long> timestamps = sensRepo.findBySensorIdAndSensorValue(sensorId, value);
        if (Objects.isNull(timestamps) || timestamps.isEmpty()) {
            return new ArrayList<>();
        }
        return timestamps.stream().map(this::getLocalDateTime).collect(Collectors.toList());
    }

    private LocalDateTime getLocalDateTime(long timestamp){
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private long getMillis(LocalDateTime timestamp) {
        ZonedDateTime zdt = ZonedDateTime.of(timestamp, ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }
}
