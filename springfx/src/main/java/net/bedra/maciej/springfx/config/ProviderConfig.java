package net.bedra.maciej.springfx.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import lombok.extern.slf4j.Slf4j;
import net.bedra.maciej.springfx.ColorsPalette;
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
        log.debug("Spring Boot context initialized");

        return acac;
    }

    /**
     * Initialize colors palette that will be available for whole application
     * (Spring Boot bean).
     * 
     * @return ColorsPalette colors palette available for whole application
     */
    @Bean
    public ColorsPalette colorsPalette() {
        log.debug("Initializing colors palette");
        ColorsPalette colorsPalette = new ColorsPalette();
        log.debug("Colors palette initialized");

        return colorsPalette;
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
        log.debug("Initializing FXML provider");
        FXMLProvider fxmlProvider = new FXMLProvider(applicationContext);
        log.debug("FXML provider initialized");

        return fxmlProvider;
    }

}