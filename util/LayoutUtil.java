package houseplanner.util;

import houseplanner.model.Room;

public class LayoutUtil {

    // Calculate area of a room
    public static int calculateArea(Room room) {
        return room.getWidth() * room.getHeight();
    }

    // Calculate total used width (simple layout)
    public static int totalRoomWidth(Room[] rooms) {
        int total = 0;
        for (Room room : rooms) {
            total += room.getWidth();
        }
        return total;
    }
}
