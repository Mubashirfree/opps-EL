package houseplanner.model;

public abstract class Room {
	 protected String name;
	    protected int width;
	    protected int height;

	    public Room(String name, int width, int height) {
	        this.name = name;
	        this.width = width;
	        this.height = height;
	    }

	    public String getName() { return name; }
	    public int getWidth() { return width; }
	    public int getHeight() { return height; }
	}