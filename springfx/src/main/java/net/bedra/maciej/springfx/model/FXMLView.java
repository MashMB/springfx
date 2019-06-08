package net.bedra.maciej.springfx.model;

import lombok.Getter;

/**
 * Representation of FXML view.
 * 
 * @author Maciej Bedra
 */
public class FXMLView {

    @Getter
    private final Object component;

    @Getter
    private final Object controller;

    /**
     * FXMLView constructor.
     * 
     * @param component  component with loaded FXML view
     * @param controller controller of the loaded FXML view
     */
    public FXMLView(Object component, Object controller) {
        this.component = component;
        this.controller = controller;
    }

}