package main.java.iot.entities;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.*;
import main.java.iot.enumirations.SensorTypes;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "objectId")
@ToString(exclude = "objectId")

@Document(collection = "sensor_types")
public class SensorTypeEntity {

    @Id
    private ObjectId objectId;

    private int sensorId;
    private String sensorName;
    private String sensorLocation;
    private SensorTypes sensorType;
    private SensorMapperEntity sensorMapperDto;
    private SensorNormallyValuesEntity sensorNormallyValuesDto;
    private SensorContactsEntity sensorContactsDto;
//    private ActionsLogEntity actionsLogEntity;

}
