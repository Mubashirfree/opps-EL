package houseplanner.util;

public class DimensionUtil {

    // Check if dimensions are valid (positive)
    public static boolean isValidDimension(int width, int height) {
        return width > 0 && height > 0;
    }

    // Ensure room fits inside house
    public static boolean canFitInsideHouse(
            int houseWidth, int houseHeight,
            int roomWidth, int roomHeight) {

        return roomWidth <= houseWidth && roomHeight <= houseHeight;
    }
}
