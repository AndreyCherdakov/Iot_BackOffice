package main.java.iot.entities;

import lombok.*;
import main.java.iot.enumirations.SensorActions;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "objectId")
@ToString(exclude = "objectId")

@Document(collection = "actions_log")

public class ActionsLogEntity {

    @Id
    private ObjectId objectId;

    private int sensorId;
    private long timestamp;
    private SensorActions actions;

}
