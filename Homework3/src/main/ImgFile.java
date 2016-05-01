package main;

import java.awt.Graphics2D;
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
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	private static BufferedImage origImg;
	private static BufferedImage resImg;
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("src/resources/Heart_Filled-128.png");
		
		try {
		origImg = ImageIO.read(file);
		resImg = new BufferedImage(WIDTH, HEIGHT, origImg.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graphics2D g = resImg.createGraphics();
		g.drawImage(origImg, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		
		
		for (int y = 0; y < origImg.getHeight(); y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < origImg.getWidth(); x++) {
				sb.append(origImg.getRGB(x, y) == -16777216 ? "#" : origImg.getRGB(x, y) == -1 ? " " : "*");
			}
			if (sb.toString().trim().isEmpty()) continue;
			System.out.println(sb);
		}
		
		for (int y = 0; y < resImg.getHeight(); y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < resImg.getWidth(); x++) {
				sb.append(resImg.getRGB(x, y) == -16777216 ? "#" : resImg.getRGB(x, y) == -1 ? " " : "*");
			}
			if (sb.toString().trim().isEmpty()) continue;
			System.out.println(sb);
		}
	}

}
