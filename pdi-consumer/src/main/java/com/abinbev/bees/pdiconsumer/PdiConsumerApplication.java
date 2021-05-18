package com.abinbev.bees.pdiconsumer;

import com.abinbev.bees.pdiconsumer.repositories.MessageRepository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MessageRepository.class)
@SpringBootApplication
public class PdiConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdiConsumerApplication.class, args);
	}

}
