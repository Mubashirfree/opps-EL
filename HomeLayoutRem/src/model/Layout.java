package model;


import java.util.ArrayList;
import java.util.List;

public class Layout {
    private List<Room> rooms;
    private int totalWidth;
    private int totalHeight;

    public Layout() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getTotalWidth() { return totalWidth; }
    public void setTotalWidth(int totalWidth) { this.totalWidth = totalWidth; }
    
    public int getTotalHeight() { return totalHeight; }
    public void setTotalHeight(int totalHeight) { this.totalHeight = totalHeight; }
}