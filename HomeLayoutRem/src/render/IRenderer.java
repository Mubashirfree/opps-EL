package render;

import model.Layout;
import java.io.IOException;

public interface IRenderer {
    // Returns a byte array so it can be easily sent over an API or saved as a file
    byte[] renderToImage(Layout layout) throws IOException;
}