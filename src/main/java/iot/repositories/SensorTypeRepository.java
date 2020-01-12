package main.java.iot.repositories;

import main.java.iot.entities.SensorNormallyValuesEntity;
import main.java.iot.entities.SensorTypeEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "SensorTypeRepository")
public interface SensorTypeRepository extends MongoRepository<SensorTypeEntity, ObjectId> {

    public SensorTypeEntity findBySensorId(int sensorId);
}
