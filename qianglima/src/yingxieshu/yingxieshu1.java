package yingxieshu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class yingxieshu1 {

	
	public static void main(String[] args) throws IOException {
        BufferedImage im= ImageIO.read(new File("D:\\java\\145303100168558.png"));//读取图片
        int width = im.getWidth();
        int height = im.getHeight();
        for(int i = 0; i < width; i++){
            for(int j = 0; j< height; j++){
                int color=im.getRGB(i, j);
                int r=(color>>16)&255;//获取red分量
                im.setRGB(i,j,0);
                if(r%2 == 1){
                    im.setRGB(i, j, 255);
                }
            }
        }
        File outputfile = new File("D:\\java\\res.png");
        ImageIO.write(im, "png",outputfile);
    }
}
