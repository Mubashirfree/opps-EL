package engine;

import model.Layout;
import model.Room;
import service.ILayoutEngine;
import java.util.List;

public class SimpleLayoutEngine implements ILayoutEngine {
    // This matches the land width provided by the user (e.g., 30 units)
    private static final int MAX_HOUSE_WIDTH = 30; 
    private static final int MARGIN = 0; // No margin needed if we want it to look like a floor plan

    @Override
    public Layout arrangeRooms(List<Room> rooms) {
        Layout layout = new Layout();
        int currentX = 0;
        int currentY = 0;
        int rowMaxHeight = 0;
        int totalHouseWidth = 0;

        for (Room room : rooms) {
            // If the next room exceeds the land width, wrap to the next row
            if (currentX + room.getWidth() > MAX_HOUSE_WIDTH) {
                currentX = 0;
                currentY += rowMaxHeight; // Move down by exactly the height of the tallest room
                rowMaxHeight = 0;
            }

            room.setX(currentX);
            room.setY(currentY);

            // Update row tracking - NO +10 or +15 gaps here
            rowMaxHeight = Math.max(rowMaxHeight, room.getLength());
            currentX += room.getWidth(); 
            
            totalHouseWidth = Math.max(totalHouseWidth, currentX);
            layout.addRoom(room);
        }

        layout.setTotalWidth(totalHouseWidth);
        layout.setTotalHeight(currentY + rowMaxHeight);
        return layout;
    }
}