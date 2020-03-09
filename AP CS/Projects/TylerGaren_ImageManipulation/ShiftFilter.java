import java.util.*;
public class ShiftFilter implements Filter {
    public void filter(PixelImage pi) {
        double explosionFactor = 20;
        Pixel[][] data = pi.getData();
        Pixel[][] newData = new Pixel[data.length][data[0].length];
        for (int y = 0; y < newData.length; y++)
            for (int x = 0; x < newData[y].length; x++)
                newData[y][x] = data[y][x];
        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data[y].length; x++) {
                int xoff = ((int) Math.round((Math.random() * explosionFactor) - explosionFactor / 2)) * 2;
                int yoff = ((int) Math.round((Math.random() * explosionFactor) - explosionFactor / 2)) * 2;
                int newX = x + xoff;
                int newY = y + yoff;
                if (newX < 0 || newX > data[y].length - 1)
                    newX = x;
                if (newY < 0 || newY > data.length - 1)
                    newY = y;
                newData[newY][newX] = data[y][x];
            }
        }
        pi.setData(newData);
    }
}