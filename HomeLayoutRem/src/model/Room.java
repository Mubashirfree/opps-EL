package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private RoomType type;
    private int width;
    private int length;
    private int x;
    private int y;

    public Room(String name, RoomType type, int width, int length) {
        this.name = name;
        this.type = type;
        this.width = width;
        this.length = length;
    }

    // Getters and Setters
    public String getName() { return name; }
    public RoomType getType() { return type; }
    public int getWidth() { return width; }
    public int getLength() { return length; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}