package com.matheuskya.user_service.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class DataLoader {
    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository){
        return args -> {
            User user1 = new User();
            user1.setName("matheus");
            user1.setPassword("123");
            User user2 = new User();
            user2.setName("lucas");
            user2.setPassword("123");

            userRepository.save(user1);
            userRepository.save(user2);

          log.info("preloading" + user1);
          log.info("preloading" + user2);
        };
    }
}
