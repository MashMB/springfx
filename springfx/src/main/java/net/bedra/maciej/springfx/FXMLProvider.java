package net.bedra.maciej.springfx;

import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.bedra.maciej.springfx.exceptions.FXMLException;

/**
 * Set of tools for FXML views handling.
 * 
 * @author Maciej Bedra
 */
@Slf4j
public class FXMLProvider {

    private final AnnotationConfigApplicationContext applicationContext;

    private ResourceBundle languagePack;
    private Stage primaryStage;

    /**
     * FXMLProvider constructor.
     * 
     * @param applicationContext Spring Boot application context
     */
    public FXMLProvider(AnnotationConfigApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Set language pack for FXML provider to transfer it later to other components.
     * 
     * @param bundle language pack bundle
     */
    public void setLanguagePack(ResourceBundle bundle) {
        log.debug("Setting language pack for FXML provider [baseBundleName = {}]",
                bundle != null ? bundle.getBaseBundleName() : null);

        if (bundle == null) {
            throw new FXMLException("Language pack is null");
        }

        if (languagePack != null) {
            throw new FXMLException("Language pack is already assigned");
        }

        languagePack = bundle;
        log.debug("Language pack for FXML provider set [baseBundleName = {}]", languagePack.getBaseBundleName());
    }

    /**
     * Set primary stage for FXML provider to use it later for loading FXML content.
     * 
     * @param stage Java FX primary application stage
     */
    public void setPrimaryStage(Stage stage) {
        log.debug("Setting primary stage for FXML provider [stage = {}]", stage != null ? stage.toString() : null);

        if (stage == null) {
            throw new FXMLException("Stage is null");
        }

        if (primaryStage != null) {
            throw new FXMLException("Primary stage is already assigned");
        }

        primaryStage = stage;
        log.debug("Primary stage for FXML provider set [primaryStage = {}]", primaryStage.toString());
    }

}