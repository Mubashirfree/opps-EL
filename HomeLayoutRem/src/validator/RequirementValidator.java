package validator;



import model.Room;
import exception.ImpossibleLayoutException;
import java.util.List;

public class RequirementValidator {
    
    public void validateRequirements(int landWidth, int landLength, List<Room> rooms) 
            throws ImpossibleLayoutException {
        
        int totalLandArea = landWidth * landLength;
        int totalRequiredArea = 0;

        for (Room room : rooms) {
            totalRequiredArea += (room.getWidth() * room.getLength());
        }

        // Rule 1: Area Check
        if (totalRequiredArea > totalLandArea) {
            throw new ImpossibleLayoutException("Not Possible: Total room area (" + totalRequiredArea + 
                ") exceeds land area (" + totalLandArea + ").");
        }

        // Rule 2: Boundary Check (A single room can't be wider than the land)
        for (Room room : rooms) {
            if (room.getWidth() > landWidth || room.getLength() > landLength) {
                throw new ImpossibleLayoutException("Not Possible: Room '" + room.getName() + 
                    "' is larger than the land dimensions.");
            }
        }
    }
}