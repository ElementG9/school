public class SwapColorsFilter implements Filter {
   public void filter(PixelImage pi) {
       Pixel[][] data = pi.getData();    
       Pixel[][] newData = new Pixel[data.length][data[0].length];
       for (int y = 0; y < data.length; y++) {
           for (int x = 0; x < data[y].length; x++) {
               Pixel p = data[y][x];
               newData[y][x] = new Pixel(p.getBlue(), p.getRed(), p.getGreen());
           }
       }
       pi.setData(newData);
    }
}
