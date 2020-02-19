public class FlipVerticalFilter implements Filter
{
   public void filter(PixelImage pi) {
       Pixel[][] data = pi.getData();    
       Pixel[][] newData = new Pixel[data.length][data[0].length];
       for (int i = 0; i < data.length; i++)
           newData[data.length - i - 1] = data[i];
       pi.setData(newData);
    }
}
