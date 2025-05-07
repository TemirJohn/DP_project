package org.Temirjohn.entity;

import java.io.IOException;

/**
 * {@summary Custom exception for when an entity's sprite cannot be found.}
 */

public class SpriteNotFoundException extends IOException {

    /**
     * @param path File path of sprite that could not be found.
     */
    public SpriteNotFoundException(String path) {
        super("Sprite could not be found at " + path + ".");
    }
}
