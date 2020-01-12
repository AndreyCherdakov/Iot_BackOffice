package main.java.iot.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Setter

public class SensorDto {

    private int sensorId;
    private double[] sensorValue;
    private double[] sensorValuePrev;
    private long timestamp;
    private long timestampPrev;
    private String sensorType;

}
