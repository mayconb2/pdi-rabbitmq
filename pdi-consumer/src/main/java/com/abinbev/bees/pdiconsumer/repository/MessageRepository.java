package com.abinbev.bees.pdiconsumer.repository;

import com.abinbev.bees.pdiconsumer.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}
