package com.example.employeescrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataGenerator {

  private static final Logger log = LoggerFactory.getLogger(DataGenerator.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {
    if (!repository.findAll().isEmpty()) {
      return args -> {};
    }

    return args -> {
      log.info(
          "Preloading "
              + repository.save(Employee.builder().name("Bilbo Baggins").role("burglar").build()));
      log.info(
          "Preloading "
              + repository.save(Employee.builder().name("Frodo Baggins").role("thief").build()));
    };
  }
}
