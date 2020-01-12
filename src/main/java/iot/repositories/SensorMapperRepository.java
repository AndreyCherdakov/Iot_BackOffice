package main.java.iot.repositories;

import main.java.iot.entities.SensorMapperEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "SensorMapperRepository")
public interface SensorMapperRepository extends MongoRepository<SensorMapperEntity, ObjectId> {

    public SensorMapperEntity findBySensorId(int sensorId);
}
