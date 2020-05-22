package tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ImageCompare {
	static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
		if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
			for (int x = 0; x < img1.getWidth(); x++) {
				for (int y = 0; y < img1.getHeight(); y++) {
					if (img1.getRGB(x, y) != img2.getRGB(x, y))
						return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedImage image1 = ImageIO.read(new FileInputStream("C:/imageCompare/img1.jpg"));
		BufferedImage image2 = ImageIO.read(new FileInputStream("C:/imageCompare/img1.jpg"));
		boolean diff = bufferedImagesEqual(image1, image2);
		System.out.println(diff);
	}
}
