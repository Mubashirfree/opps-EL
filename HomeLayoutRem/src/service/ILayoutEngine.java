package service;


import model.Layout;
import model.Room;
import java.util.List;

public interface ILayoutEngine {
    /**
     * Takes a list of rooms and determines their positions.
     */
    Layout arrangeRooms(List<Room> rooms);
}