package net.bedra.maciej.springfx.exceptions;

/**
 * Exception to handle errors connected with FXML.
 * 
 * @author Maciej Bedra
 */
public class FXMLException extends RuntimeException {

    /**
     * FXMLException constructor.
     * 
     * @param message error message
     */
    public FXMLException(String message) {
        super(message);
    }

}