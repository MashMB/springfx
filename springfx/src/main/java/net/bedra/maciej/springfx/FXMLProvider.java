package net.bedra.maciej.springfx;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.bedra.maciej.springfx.exception.FXMLException;
import net.bedra.maciej.springfx.model.FXMLView;

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
    private Map<String, URL> views = new TreeMap<>();

    /**
     * FXMLProvider constructor.
     * 
     * @param applicationContext Spring Boot application context
     */
    public FXMLProvider(AnnotationConfigApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Get FXML view from provider collection for accessible name.
     * 
     * @param name accessible FXML view name
     * @return URL FXML view location
     */
    public URL getView(String name) {
        log.debug("Getting FXML view from provider collection [name = {}]", name);

        if (StringUtils.isEmpty(name)) {
            throw new FXMLException("Accessible FXML view name is null");
        }

        if (!views.containsKey(name)) {
            throw new FXMLException("FXML view not exists");
        }

        URL view = views.get(name);
        log.debug("FXML view found in provider collection [path = {}]", view.getPath());

        return view;
    }

    /**
     * Load FXML view to an object that wraps any JavaFX component that can be used
     * as placeholder and it's controller.
     * 
     * @param name accessible name of the FXML view to load
     * @return FXMLView FXML view wrapper that contains component with loaded view
     *         and it's controller
     */
    public FXMLView loadView(String name) {
        log.debug("Loading FXML view for name [name = {}]", name);
        FXMLView fxmlView = null;
        URL view = getView(name);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setResources(languagePack);
        fxmlLoader.setLocation(view);

        try {
            Object component = fxmlLoader.load();
            Object controller = fxmlLoader.getController();
            fxmlView = new FXMLView(component, controller);
        } catch (IOException ex) {
            log.error("Error occurred while loading FXML view", ex);
            throw new FXMLException("FXML view loading failed");
        }

        log.debug("FXML view loaded for name [name = {}, view = {}]", name, fxmlView.toString());

        return fxmlView;
    }

    /**
     * Add FXML view to provider collection with accessible name.
     * 
     * @param name accessible name for FXML view
     * @param path path to FXML view file
     */
    public void addView(String name, String path) {
        log.debug("Adding FXML view to provider collection [name = {}, path = {}]", name, path);

        if (StringUtils.isEmpty(name)) {
            throw new FXMLException("Accessible FXML view name is null");
        }

        if (views.containsKey(name)) {
            throw new FXMLException("FXML view for name already exists in views collection");
        }

        if (StringUtils.isEmpty(path)) {
            throw new FXMLException("Path to FXML view is null");
        }

        URL view = getClass().getResource(path);

        if (view == null) {
            throw new FXMLException("Invalid path to FXML view");
        }

        views.put(name, view);
        log.debug("FXML view added to provider collection [name = {}, path = {}]", name, view.getPath());
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