package com.abinbev.bees.pdiservice.repository;

import com.abinbev.bees.pdiservice.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}