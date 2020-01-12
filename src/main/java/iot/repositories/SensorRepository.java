package main.java.iot.repositories;

import main.java.iot.entities.SensorEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "SensorRepository")
public interface SensorRepository extends MongoRepository<SensorEntity, ObjectId> {

    List<SensorEntity> findBySensorIdAndTimestampBetween(int sensorId, long from, long to);
    List<SensorEntity> findAllBySensorId(int sensorId);
    List<SensorEntity> findBySensorTypeAndTimestampBetween(String sensorType, long from, long to);
    List<Long> findBySensorIdAndSensorValue(int sensorId, double[] value);

}
