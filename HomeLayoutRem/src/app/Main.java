package app;

import model.*;
import service.HouseLayoutService;
import engine.SimpleLayoutEngine;
import validator.RequirementValidator;
import render.HouseRenderer;
import exception.ImpossibleLayoutException;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RequirementValidator validator = new RequirementValidator();
        
        try {
            // 1. Get Land Dimensions
            System.out.println("Enter Land Width (e.g., 30): ");
            int landW = scanner.nextInt();
            System.out.println("Enter Land Length (e.g., 40): ");
            int landL = scanner.nextInt();

            // 2. Get Room Requirements
            List<Room> rooms = new ArrayList<>();
            System.out.println("How many bedrooms do you want?");
            int bedCount = scanner.nextInt();
            
            for (int i = 1; i <= bedCount; i++) {
                // Assuming standard size for calculation
                rooms.add(new Room("Bedroom " + i, RoomType.BEDROOM, 12, 12));
            }

            System.out.println("How many washrooms do you want?");
            int bathCount = scanner.nextInt();
            for (int i = 1; i <= bathCount; i++) {
                rooms.add(new Room("Bath " + i, RoomType.WASHROOM, 6, 8));
            }

            // Add a mandatory Hall
            rooms.add(new Room("Hall", RoomType.HALL, 15, 20));

            // 3. VALIDATE BEFORE GENERATING
            validator.validateRequirements(landW, landL, rooms);

            // 4. If valid, proceed to Engine and Renderer
            SimpleLayoutEngine engine = new SimpleLayoutEngine();
            HouseRenderer renderer = new HouseRenderer();
            
            Layout layout = engine.arrangeRooms(rooms);
            // Note: In a real app, you'd pass landW/landL to the engine to constrain the grid
            
            byte[] image = renderer.renderToImage(layout);
            try (FileOutputStream fos = new FileOutputStream("user_layout.png")) {
                fos.write(image);
                System.out.println("Success! Layout saved to user_layout.png");
            }

        } catch (ImpossibleLayoutException e) {
            System.err.println("REJECTION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}