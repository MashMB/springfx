package net.bedra.maciej.springfx.exception;

/**
 * Exception used to handle errors connected with colors provider (collection).
 * 
 * @author Maciej Bedra
 */
public class ColorsPaletteException extends RuntimeException {

    /**
     * ColorsPaletteException constructor.
     * 
     * @param message error message
     */
    public ColorsPaletteException(String message) {
        super(message);
    }

}