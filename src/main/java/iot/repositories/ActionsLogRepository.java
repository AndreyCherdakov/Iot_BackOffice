package main.java.iot.repositories;

import main.java.iot.entities.ActionsLogEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ActionsLogRepository")
public interface ActionsLogRepository extends MongoRepository<ActionsLogEntity, ObjectId> {

}
