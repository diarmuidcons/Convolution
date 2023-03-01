package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageUtils {

	// Could be a user param. Didn't have time (multiplier for the kernel filter
	// values)
	private static final int MULT_FACTOR = 1;

	public ImageUtils() {
	}

	public BufferedImage readImage(String filePath) throws IOException {
		// read in inputImage after scanner gets file path from the user
		BufferedImage img = ImageIO.read(new File(filePath));
		return img;
	}

	public BufferedImage writeImageToFile(BufferedImage inputImage, String outputPathName) throws IOException {
		// write out file in png format, while also taking in scanner input from Menu
		// class
		ImageIO.write(inputImage, "png", new File(outputPathName));
		return inputImage;
	}

	// takes in Buffered image after original image is read, and applies convolution
	// method from below
	public BufferedImage filterImage(BufferedImage inputImage, double[][] filter) throws Exception {
		System.out.println("Filtering inputImage with filter: " + Arrays.deepToString(filter));
		return doFiltering(inputImage, filter);
	}

	private BufferedImage doFiltering(BufferedImage inputImage, double[][] kernel) {
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		int order = kernel.length;
		BufferedImage outputImage = new BufferedImage(width, height, inputImage.getType());
		// iterates over each pixel in image
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				// set values to zero on every iteration
				float red = 0f;
				float green = 0f;
				float blue = 0f;

				// loop over kernel filter
				for (int i = 0; i < order; i++) {
					for (int j = 0; j < order; j++) {
						// wraps the image so that the filter can act on the outermost pixels
						int imageX = (x - order / 2 + i + width) % width;
						int imageY = (y - order / 2 + j + height) % height;
						// gets the RGB of the image
						int RGB = inputImage.getRGB(imageX, imageY);
						int R = (RGB >> 16) & 0xff;
						int G = (RGB >> 8) & 0xff;
						int B = (RGB) & 0xff;

						// multiplies RGB by the kernel in use
						red += (R * kernel[i][j]);
						green += (G * kernel[i][j]);
						blue += (B * kernel[i][j]);
					}
				}
				int outR, outG, outB;

				outR = Math.min(Math.max((int) (red * MULT_FACTOR), 0), 255);
				outG = Math.min(Math.max((int) (green * MULT_FACTOR), 0), 255);
				outB = Math.min(Math.max((int) (blue * MULT_FACTOR), 0), 255);
				// set new image RGB based on the above calculations
				outputImage.setRGB(x, y, new Color(outR, outG, outB).getRGB());
			}
		}

		return outputImage;
	}

}