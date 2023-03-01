package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Runner {

	public static void main(String[] args) throws Exception {
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		showOptions();
	}

	private static void showOptions() throws Exception {
		Menu menu = new Menu();
		ImageUtils imageUtils = new ImageUtils();

		// C:\Users\Toshiba\Desktop\bridge-rgb.png
		System.out.println("1) Enter Source Image Path Name\n");
		String imagePathName = menu.getImagePathName();
		// user inputs image file name, method from ImageUtils called to read image
		System.out.println("Input Image path: " + imagePathName);

		System.out.println("2) Select a Filter\n");
		double[][] filter = menu.getFilterChoice();
		// method for switch statement for filters is called, and users choice is set as
		// filter
		System.out.println("Filter: " + Arrays.deepToString(filter));

		// C:\Users\Toshiba\Desktop\filteredbridge-rgb.png
		System.out.println("3) Enter Output Path Name\n");
		String outputPathName = menu.getOutputPathName();

		// method for writing the filtered image gets called from imageUtils class, with
		// scanner allowing user to name filepath
		System.out.println("Output Image path: " + outputPathName);

		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
		System.out.println(ConsoleColour.RESET);

		// 1. read image
		BufferedImage img = imageUtils.readImage(imagePathName);
		// 2. filter image
		BufferedImage filterImage = imageUtils.filterImage(img, filter);
		// 3. write image
		BufferedImage writeImage = imageUtils.writeImageToFile(filterImage, outputPathName);

	}

}
