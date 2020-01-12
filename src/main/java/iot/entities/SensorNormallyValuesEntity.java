package main.java.iot.entities;

import lombok.*;
import main.java.iot.enumirations.SensorActions;
import main.java.iot.enumirations.SensorOperations;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "objectId")
@ToString(exclude = "objectId")

@Document(collection = "sensor_normally_values")
public class SensorNormallyValuesEntity {

    @Id
    private ObjectId objectId;

    private int sensorId;
    private double sensorMinValue;
    private double sensorMaxValue;
    private double sensorEqValue;
    private double sensorLTValue;
    private double sensorGTValue;
    private SensorOperations operation;
    private SensorActions action;

}
