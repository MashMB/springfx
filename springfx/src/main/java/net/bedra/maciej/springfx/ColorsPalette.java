package net.bedra.maciej.springfx;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.util.StringUtils;

import javafx.scene.paint.Paint;
import lombok.extern.slf4j.Slf4j;
import net.bedra.maciej.springfx.exception.ColorsPaletteException;

/**
 * Colors provider (collection) for whole application.
 * 
 * @author Maciej Bedra
 */
@Slf4j
public class ColorsPalette {

    private final Map<String, Paint> colors = new TreeMap<>();

    /**
     * ColorsPalette constructor.
     * 
     * @param confPalette colors definitions from configuration
     */
    public ColorsPalette(Map<String, String> confPalette) {
        initialize(confPalette);
    }

    /**
     * Get color from palette for accessible name.
     * 
     * @param name accessible name of the color
     * @return Paint real color value that can be used in JavaFX application
     */
    public Paint getColor(String name) {
        log.debug("Getting color from palette [name = {}]", name);
        Paint color = null;

        if (StringUtils.isEmpty(name)) {
            throw new ColorsPaletteException("Accessible color name is null");
        }

        if (!colors.containsKey(name)) {
            throw new ColorsPaletteException("Color not exists");
        }

        color = colors.get(name);

        log.debug("Color found in palette [color = {}]", color.toString());

        return color;
    }

    /**
     * Add new color to palette.
     * 
     * @param name accessible name of the color
     * @param hex  hexadecimal representation of new color
     */
    public void addColor(String name, String hex) {
        log.debug("Adding color to palette [name = {}, hex = {}]", name, hex);
        Paint color = null;

        if (StringUtils.isEmpty(name)) {
            throw new ColorsPaletteException("Color accessible name is null");
        }

        if (StringUtils.isEmpty(hex)) {
            throw new ColorsPaletteException("Color hex is null");
        }

        if (hex.charAt(0) != '#') {
            hex = "#" + hex;
        }

        try {
            color = Paint.valueOf(hex);
        } catch (NullPointerException | IllegalArgumentException ex) {
            log.error("Color not exists", ex);
            throw new ColorsPaletteException("Color not exists");
        }

        if (colors.containsKey(name)) {
            throw new ColorsPaletteException("Color for name already exists in colors collection");
        }

        if (colors.containsValue(color)) {
            throw new ColorsPaletteException("Color already defined in colors collection");
        }

        colors.put(name, color);
        log.debug("Color added to palette [color = {}]", color.toString());
    }

    /**
     * Iterate over colors definitions and initialize colors palette.
     * 
     * @param confPalette colors definitions from configuration
     */
    private void initialize(Map<String, String> confPalette) {
        log.debug("Initializing colors palette with configuration [confPalette size = {}]",
                confPalette != null ? confPalette.size() : null);

        if (confPalette != null && !confPalette.isEmpty()) {
            for (Map.Entry<String, String> definition : confPalette.entrySet()) {
                addColor(definition.getKey(), definition.getValue());
            }
        }

        log.debug("Colors palette initialized with configuration [colorsPalette size = {}]", colors.size());
    }

}