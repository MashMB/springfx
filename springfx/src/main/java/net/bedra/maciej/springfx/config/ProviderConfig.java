package net.bedra.maciej.springfx.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import lombok.extern.slf4j.Slf4j;
import net.bedra.maciej.springfx.FXMLProvider;

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

    /**
     * Initialize FXML provider with Spring Boot application context and make bean
     * from it for easy FXML views handling.
     * 
     * @param applicationContext Spring Boot application context
     * @return FXMLProvider FXML views provider
     */
    @Bean
    @DependsOn("applicationContext")
    public FXMLProvider fxmlProvider(AnnotationConfigApplicationContext applicationContext) {
        log.debug("Initializing FXML provider [contextName = {}]", applicationContext.getDisplayName());
        FXMLProvider fxmlProvider = new FXMLProvider(applicationContext);
        log.debug("FXML provider initialized [fxmlProvider = {}]", fxmlProvider.toString());

        return fxmlProvider;
    }

}