package com.curioushead;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@SpringBootApplication
public class ApplicationRoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRoot.class, args);
    }
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("Australia", "NSW", "Sydney", "Carlingford",
                    "2118");
            Student student = new Student("Madhur", "Bhandari", "madhur.mrules@gmail.com",
                    Gender.MALE, address, List.of("Bioinformatics, Computer Science"), LocalDateTime.now());
            Query query = new Query();
            query.addCriteria(Criteria.where("email").is("madhur.mrules@gmail.com"));
            List<Student> students = mongoTemplate.find(query, Student.class);
            if (students.size() > 1) {
                throw new IllegalStateException("found many students with this email");
            }
            if (students.isEmpty()) {
                logger.info("Inserting record...");
                repository.insert(student);
            } else {
                logger.info("Student already exists");
            }
        };
    }
}