package validator;


import model.Layout;
import model.Room;
import service.ILayoutValidator;

public class BasicValidator implements ILayoutValidator {

    @Override
    public boolean validate(Layout layout) {
        if (layout.getRooms().isEmpty()) return false;

        for (Room room : layout.getRooms()) {
            // Business Rule: No room can be smaller than 10x10 units
            if (room.getWidth() < 10 || room.getLength() < 10) {
                return false;
            }
        }
        return true;
    }
}