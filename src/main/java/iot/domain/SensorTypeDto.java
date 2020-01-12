package main.java.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.iot.enumirations.SensorTypes;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SensorTypeDto {

    private int sensorId;
    private String sensorName;
    private String sensorLocation;
    private SensorTypes sensorType;
    private SensorMapperDto sensorMapperDto;
    private SensorNormallyValuesDto sensorNormallyValuesDto;
    private SensorContactsDto sensorContactsDto;

}
