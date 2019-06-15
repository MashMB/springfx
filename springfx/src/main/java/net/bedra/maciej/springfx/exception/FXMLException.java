package net.bedra.maciej.springfx.exception;

/**
 * Exception to handle errors connected with FXML.
 * 
 * @author Maciej Bedra
 */
public class FXMLException extends RuntimeException {

    private static final long serialVersionUID = -481836061900375825L;

    /**
     * FXMLException constructor.
     * 
     * @param message error message
     */
    public FXMLException(String message) {
        super(message);
    }

}