public class GaussianBlurFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        int[][] redData = new int[data.length][data[0].length];
        int[][] greenData = new int[data.length][data[0].length];
        int[][] blueData = new int[data.length][data[0].length];
        int[][] filter = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
        Pixel[][] newData = applyFilter(data, filter);
        pi.setData(newData);
    }

    private Pixel[][] applyFilter(Pixel[][] data, int[][] filter) {
        Pixel[][] newData = new Pixel[data.length][data[0].length];
        if (filter.length != 3 || filter[0].length != 3)
            throw new IllegalArgumentException("filter provided is not 3x3");
        int filterSum = 0;
        for (int[] a : filter)
            for (int b : a)
                filterSum += b;
        for (int y = 0; y < data.length; y++) { // Skip the edges
            for (int x = 0; x < data[y].length; x++) {
                if (y == 0 || y + 1 == data.length || x == 0 || x + 1 == data[y].length) {
                    newData[y][x] = data[y][x];
                } else {
                    int redVal = 0;
                    redVal += filter[0][0] * (data[y-1][x-1]).getRed();
                    redVal += filter[0][1] * (data[y-1][x]).getRed();
                    redVal += filter[0][2] * (data[y-1][x+1]).getRed();
                    redVal += filter[1][0] * (data[y][x-1]).getRed();
                    redVal += filter[1][1] * (data[y][x]).getRed();
                    redVal += filter[1][2] * (data[y][x+1]).getRed();
                    redVal += filter[2][0] * (data[y+1][x-1]).getRed();
                    redVal += filter[2][1] * (data[y+1][x]).getRed();
                    redVal += filter[2][2] * (data[y+1][x+1]).getRed();
                    if (filterSum != 0)
                        redVal /= filterSum;
                    if (redVal > 255)
                        redVal = 255;
                    if (redVal < 0)
                        redVal = 0;
                    int greenVal = 0;
                    greenVal += filter[0][0] * (data[y-1][x-1]).getGreen();
                    greenVal += filter[0][1] * (data[y-1][x]).getGreen();
                    greenVal += filter[0][2] * (data[y-1][x+1]).getGreen();
                    greenVal += filter[1][0] * (data[y][x-1]).getGreen();
                    greenVal += filter[1][1] * (data[y][x]).getGreen();
                    greenVal += filter[1][2] * (data[y][x+1]).getGreen();
                    greenVal += filter[2][0] * (data[y+1][x-1]).getGreen();
                    greenVal += filter[2][1] * (data[y+1][x]).getGreen();
                    greenVal += filter[2][2] * (data[y+1][x+1]).getGreen();
                    if (filterSum != 0)
                        greenVal /= filterSum;
                    if (greenVal > 255)
                        greenVal = 255;
                    if (greenVal < 0)
                        greenVal = 0;
                    int blueVal = 0;
                    blueVal += filter[0][0] * (data[y-1][x-1]).getBlue();
                    blueVal += filter[0][1] * (data[y-1][x]).getBlue();
                    blueVal += filter[0][2] * (data[y-1][x+1]).getBlue();
                    blueVal += filter[1][0] * (data[y][x-1]).getBlue();
                    blueVal += filter[1][1] * (data[y][x]).getBlue();
                    blueVal += filter[1][2] * (data[y][x+1]).getBlue();
                    blueVal += filter[2][0] * (data[y+1][x-1]).getBlue();
                    blueVal += filter[2][1] * (data[y+1][x]).getBlue();
                    blueVal += filter[2][2] * (data[y+1][x+1]).getBlue();
                    if (filterSum != 0)
                        blueVal /= filterSum;
                    if (blueVal > 255)
                        blueVal = 255;
                    if (blueVal < 0)
                        blueVal = 0;
                    newData[y][x] = new Pixel(redVal, greenVal, blueVal);
                }
            }
        }
        return newData;
    }
}
