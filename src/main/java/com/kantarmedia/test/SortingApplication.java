package com.kantarmedia.test;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SortingApplication {
    public static void main(String[] args) {

        SpringApplication.run(SortingApplication.class, args);
        log.info("Application has started! Happy tests!");
    }
}
