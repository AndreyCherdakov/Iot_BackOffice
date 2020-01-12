package main.java.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.iot.enumirations.SensorActions;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ActionsLogDto {

    private int sensorId;
    private long timestamp;
    private SensorActions actions;

}
