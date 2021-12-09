package com.akqa.web.services.techtests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application initializer This class initializes TechTests application.
 *
 * @author ajay.tiwari
 */
@SpringBootApplication
public class TechTestsApplication {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(TechTestsApplication.class);

    /**
     * The main method.
     *
     * @param args the arguments passed while initiating the application
     */
    public static void main(String[] args) {
        LOG.info("Initiating tech tests application.");
        SpringApplication.run(TechTestsApplication.class, args);
    }
}
