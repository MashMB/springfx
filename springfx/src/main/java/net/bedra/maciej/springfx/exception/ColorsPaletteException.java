package net.bedra.maciej.springfx.exception;

/**
 * Exception used to handle errors connected with colors provider (collection).
 * 
 * @author Maciej Bedra
 */
public class ColorsPaletteException extends RuntimeException {

    private static final long serialVersionUID = 6552548989847450052L;

    /**
     * ColorsPaletteException constructor.
     * 
     * @param message error message
     */
    public ColorsPaletteException(String message) {
        super(message);
    }

}