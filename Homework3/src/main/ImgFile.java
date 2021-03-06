package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgFile {
	
	private static BufferedImage origImg;
	private static BufferedImage resImg;

	public static void main(String[] args) throws IOException {
		
		loadImage("src/resources/Heart_Filled-128.png");
				
		resizeImg(origImg, 10,10);
		
		sysoutImg(resImg);
		sysoutImg(origImg);
		
	}
	
	public static BufferedImage loadImage(String path) {
		File file = new File(path);
		try {
			origImg = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return origImg;
	}
	
	public static BufferedImage resizeImg(BufferedImage oImg, int width, int height) {
		resImg = new BufferedImage(width, height, oImg.getType());
		Graphics2D g = resImg.createGraphics();
		g.drawImage(oImg, 0, 0, width, height, null);
		g.dispose();
		return resImg;
	}
	
	public static void sysoutImg(BufferedImage img) {
		for (int y = 0; y < img.getHeight(); y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < img.getWidth(); x++) {
				sb.append(img.getRGB(x, y) < 0 ? "#" : " ");
//				sb.append(img.getRGB(x, y) + "  ");
			}
			if (sb.toString().trim().isEmpty()) continue;
			System.out.println(sb);
		}
	}
	

}
