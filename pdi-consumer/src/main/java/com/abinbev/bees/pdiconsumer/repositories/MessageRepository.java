package com.abinbev.bees.pdiconsumer.repositories;

import com.abinbev.bees.pdiconsumer.entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}
