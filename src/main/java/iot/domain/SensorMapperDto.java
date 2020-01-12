package main.java.iot.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SensorMapperDto {

    private int sensorId;
    private double[] sensorValue;
    private String[] fieldName;

}
