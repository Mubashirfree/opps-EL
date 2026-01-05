package houseplanner.model;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int width;
    private int height;
    private List<Room> rooms;

    public House(int width, int height) {
        this.width = width;
        this.height = height;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}