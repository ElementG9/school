import java.util.*;
public class DeepFryFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        for(int i = 0; i < 10; i++)
            (new GaussianBlurFilter()).filter(pi);
        for(int i = 0; i < 10; i++)
            (new LaplacianFilter()).filter(pi);
        int numToApply = (int) Math.floor(Math.random() * 3);
        for (int i = 0; i < numToApply; i++)
            (new SwapColorsFilter()).filter(pi);
    }
}
