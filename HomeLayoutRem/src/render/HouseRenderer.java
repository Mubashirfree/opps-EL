package render;

import model.Layout;
import model.Room;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HouseRenderer implements IRenderer {

    // 1 unit (feet/meters) will be converted to 20 pixels
    private static final int SCALE = 20; 
    private static final int PADDING = 50;

    @Override
    public byte[] renderToImage(Layout layout) throws IOException {
        // Calculate total image size based on scale
        int width = (layout.getTotalWidth() * SCALE) + (PADDING * 2);
        int height = (layout.getTotalHeight() * SCALE) + (PADDING * 2);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Improve image quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // 1. Draw Background (White Canvas)
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // 2. Draw each room
        for (Room room : layout.getRooms()) {
        	// Inside the for-loop
        	int x = (room.getX() * SCALE) + PADDING;
        	int y = (room.getY() * SCALE) + PADDING;
        	int w = room.getWidth() * SCALE;
        	int l = room.getLength() * SCALE;

        	// 1. Fill room
        	g2d.setColor(new Color(250, 250, 250));
        	g2d.fillRect(x, y, w, l);

        	// 2. Draw Shared Walls
        	g2d.setColor(Color.BLACK);
        	g2d.setStroke(new BasicStroke(2)); // Thinner stroke helps shared walls look cleaner
        	g2d.drawRect(x, y, w, l);            // 3. Draw Labels (Centered)
            g2d.setFont(new Font("SansSerif", Font.BOLD, 14));
            FontMetrics fm = g2d.getFontMetrics();
            
            String name = room.getName();
            String dimensions = room.getWidth() + "x" + room.getLength();
            
            // Center the Name
            int textX = x + (w - fm.stringWidth(name)) / 2;
            int textY = y + (l / 2);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawString(name, textX, textY);
            
            // Center the Dimension below the name
            int dimX = x + (w - fm.stringWidth(dimensions)) / 2;
            int dimY = textY + fm.getHeight();
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 11));
            g2d.drawString(dimensions, dimX, dimY);
        }

        g2d.dispose();

        // Convert to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}