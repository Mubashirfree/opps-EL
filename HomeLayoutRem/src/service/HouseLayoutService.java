package service;


import model.Layout;
import model.Room;
import java.util.List;

public class HouseLayoutService {
    private final ILayoutEngine engine;
    private final ILayoutValidator validator;

    // Dependency Injection via Constructor
    public HouseLayoutService(ILayoutEngine engine, ILayoutValidator validator) {
        this.engine = engine;
        this.validator = validator;
    }

    public Layout processUserRequest(List<Room> rooms) {
        // 1. Arrange the rooms using the engine
        Layout layout = engine.arrangeRooms(rooms);

        // 2. Validate the result
        if (!validator.validate(layout)) {
            throw new IllegalArgumentException("The requested room sizes do not fit in a valid layout.");
        }

        return layout;
    }
}