public class NegativeImageFilter implements Filter
{
   public void filter(PixelImage pi) {
       Pixel[][] data = pi.getData();    
       Pixel[][] newData = new Pixel[data.length][data[0].length];
       for (int y = 0; y < data.length; y++) {
           for (int x = 0; x < data[y].length; x++) {
               Pixel p = data[y][x];
               newData[y][x] = new Pixel(255 - p.getRed(), 255 - p.getGreen(), 255 - p.getBlue());
           }
       }
       pi.setData(newData);
    }
}
