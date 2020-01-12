package main.java.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.iot.enumirations.SensorActions;
import main.java.iot.enumirations.SensorOperations;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SensorNormallyValuesDto {

    private int sensorId;
    private double sensorMinValue;
    private double sensorMaxValue;
    private double sensorEqValue;
    private double sensorLTValue;
    private double sensorGTValue;
    private SensorOperations operation;
    private SensorActions action;

}
