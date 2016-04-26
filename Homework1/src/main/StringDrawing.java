package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.TextIO;


public class StringDrawing {
	public static void main(String[] args) throws IOException {
		int width = 100;
		int height = 100;
		
		System.out.println("Please enter a text");
		String input = TextIO.getln();
		
		/**
		 * Code taken from http://stackoverflow.com/questions/7098972/ascii-art-java
		 */
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
		Graphics g = img.getGraphics();
		g.drawString(input, 5, 95);
		
		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {
				sb.append(img.getRGB(x, y) == -16777216 ? " " : img.getRGB(x, y) == -1 ? "#" : "*");
			}
			if (sb.toString().trim().isEmpty()) continue;
			System.out.println(sb);
		}
		
	}
}





















