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

@Document(collection = "sensor_contacts")
public class SensorContactsEntity {

    @Id
    private ObjectId objectId;

    private int sensorId;
    private String email;
    private String phone;
    private String endPoint;

}
