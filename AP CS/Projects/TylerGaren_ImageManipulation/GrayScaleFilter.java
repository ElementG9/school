public class GrayScaleFilter implements Filter
{
   public void filter(PixelImage pi) {
       Pixel[][] data = pi.getData();    
       Pixel[][] newData = new Pixel[data.length][data[0].length];
       for (int y = 0; y < data.length; y++) {
           for (int x = 0; x < data[y].length; x++) {
               Pixel p = data[y][x];
               int brightness = (p.getRed() + p.getBlue() + p.getGreen())/3;
               newData[y][x] = new Pixel(brightness, brightness, brightness);
           }
       }
       pi.setData(newData);
    }
}
