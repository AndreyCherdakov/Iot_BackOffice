package main.java.iot.repositories;

import main.java.iot.entities.SensorContactsEntity;
import main.java.iot.entities.SensorMapperEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "SensorContactsRepository")
public interface SensorContactsRepository extends MongoRepository<SensorContactsEntity, ObjectId> {

    public SensorContactsEntity findBySensorId(int sensorId);
}
