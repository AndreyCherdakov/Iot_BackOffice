package main.java.iot.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(exclude = "objectId")
@ToString(exclude = "objectId")
@Setter

@Document(collection = "smartHomeData")
public class SensorEntity {

    @Id
    private ObjectId objectId;

    private int sensorId;
    private double[] sensorValue;
    private double[] sensorValuePrev;
    private long timestamp;
    private long timestampPrev;
    private String sensorType;

    public SensorEntity(int sensorId, double[] sensorValue, double[] sensorValuePrev, long timestamp, long timestampPrev, String sensorType) {
        this.sensorId = sensorId;
        this.sensorValue = sensorValue;
        this.sensorValuePrev = sensorValuePrev;
        this.timestamp = timestamp;
        this.timestampPrev = timestampPrev;
        this.sensorType = sensorType;
    }
}
