package main.java.iot.repositories;

import main.java.iot.entities.SensorMapperEntity;
import main.java.iot.entities.SensorNormallyValuesEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "SensorNormallyValuesRepository")
public interface SensorNormallyValuesRepository extends MongoRepository<SensorNormallyValuesEntity, ObjectId> {

    public SensorNormallyValuesEntity findBySensorId(int sensorId);
}
