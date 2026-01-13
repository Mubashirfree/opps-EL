package model;


public class RoomFeature {
    private FeatureType type;
    private WallSide side; // New field
    private int offset;    // Distance from the corner along that wall
    private int size;

    public RoomFeature(FeatureType type, WallSide side, int offset, int size) {
        this.type = type;
        this.side = side;
        this.offset = offset;
        this.size = size;
    }

    // Getters
    public FeatureType getType() { return type; }
    public WallSide getSide() { return side; }
    public int getOffset() { return offset; }
    public int getSize() { return size; }
}