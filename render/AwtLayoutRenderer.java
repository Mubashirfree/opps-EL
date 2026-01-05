package houseplanner.render;

import houseplanner.model.House;

public class AwtLayoutRenderer implements LayoutRenderer {

    @Override
    public void render(House house) {
        System.out.println("Rendering house using AWT...");
        System.out.println("House size: "
                + house.getWidth() + " x " + house.getHeight());
    }
}