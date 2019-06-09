package net.bedra.maciej.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * Configuration for FXML provider.
 * 
 * @author Maciej Bedra
 */
@Slf4j
@Configuration
public class ProviderConfig {

    /**
     * Initialize Spring Boot context for JavaFX FXML views handling by Spring
     * controllers.
     * 
     * @return AnnotationConfigApplicationContext initialized Spring Boot context
     */
    @Bean
    public AnnotationConfigApplicationContext applicationContext() {
        log.debug("Initializing Spring Boot context");
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        log.debug("Spring Boot context initialized [contextName = {}]", acac.getDisplayName());

        return acac;
    }

}