package com.esens.admin;

import com.esens.admin.activity.ActivityRepository;
import com.esens.admin.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdminApplication {

    private static final Logger log = LoggerFactory.getLogger(AdminApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(final UserRepository repository, final ActivityRepository activityRepository) {
        return (args) -> {
//            repository.findAll().stream().forEach(System.out::println);
            System.out.println(activityRepository.findOne(86613L));
        };
    }
}
