package net.bedra.maciej.springfx.model;

import lombok.Getter;

/**
 * Representation of FXML view.
 * 
 * @author Maciej Bedra
 */
public class FXMLView {

    @Getter
    private final String absolutePath;

    @Getter
    private final Object component;

    @Getter
    private final Object controller;

    /**
     * FXMLView constructor.
     * 
     * @param absolutePath absolute path to FXML view file
     * @param component    component with loaded FXML view
     * @param controller   controller of the loaded FXML view
     */
    public FXMLView(String absolutePath, Object component, Object controller) {
        this.absolutePath = absolutePath;
        this.component = component;
        this.controller = controller;
    }

}