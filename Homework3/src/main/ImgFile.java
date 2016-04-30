package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
//Graphics g = img.getGraphics();
//g.drawString(input, 5, 95);
//
//for (int y = 0; y < height; y++) {
//	StringBuilder sb = new StringBuilder();
//	for (int x = 0; x < width; x++) {
//		sb.append(img.getRGB(x, y) == -16777216 ? " " : img.getRGB(x, y) == -1 ? "#" : "*");
//	}
//	if (sb.toString().trim().isEmpty()) continue;
//	System.out.println(sb);

public class ImgFile {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("src/resources/Heart_Filled-128.png");
		BufferedImage img = null;
		try {
		    img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int y = 0; y < img.getHeight(); y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < img.getWidth(); x++) {
				sb.append(img.getRGB(x, y) == -16777216 ? "#" : img.getRGB(x, y) == -1 ? " " : "*");
			}
			if (sb.toString().trim().isEmpty()) continue;
			System.out.println(sb);
		}
	}

}
