package main.java.iot.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "objectId")
@ToString(exclude = "objectId")

@Document(collection = "sensor_mapper")
public class SensorMapperEntity {

    @Id
    private ObjectId objectId;

    private int sensorId;
    private double[] sensorValue;
    private String[] fieldName;

}
