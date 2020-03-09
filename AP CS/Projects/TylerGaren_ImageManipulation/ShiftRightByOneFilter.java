public class ShiftRightByOneFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        int[][] redData = new int[data.length][data[0].length];
        int[][] greenData = new int[data.length][data[0].length];
        int[][] blueData = new int[data.length][data[0].length];
        int[][] filter = {{0, 0, 0}, {1, 0, 0}, {0, 0, 0}};
        Pixel[][] newData = Helper.applyFilter(data, filter);
        pi.setData(newData);
    }
}
