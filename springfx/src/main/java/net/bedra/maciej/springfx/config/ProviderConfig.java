package net.bedra.maciej.springfx.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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
     * @param confPalette colors definitions from configuration
     * @return ColorsPalette colors palette available for whole application
     */
    @Bean
    public ColorsPalette colorsPalette(
            @Value("#{${springfx.colors-palette:T(java.util.Collections).emptyMap()}}") Map<String, String> confPalette) {
        log.debug("Initializing colors palette");
        ColorsPalette colorsPalette = new ColorsPalette(confPalette);
        log.debug("Colors palette initialized");

        return colorsPalette;
    }

    /**
     * Initialize FXML provider with Spring Boot application context and make bean
     * from it for easy FXML views handling.
     * 
     * @param applicationContext Spring Boot application context
     * @param confViews          FXML views definitions from configuration
     * @return FXMLProvider FXML views provider
     */
    @Bean
    @DependsOn("applicationContext")
    public FXMLProvider fxmlProvider(AnnotationConfigApplicationContext applicationContext,
            @Value("#{${springfx.fxml-views:T(java.util.Collections).emptyMap()}}") Map<String, String> confViews) {
        log.debug("Initializing FXML provider");
        FXMLProvider fxmlProvider = new FXMLProvider(applicationContext, confViews);
        log.debug("FXML provider initialized");

        return fxmlProvider;
    }

}