package ie.gmit.dip;

import java.util.Scanner;

public class Menu {

	public Menu() {
	}

//scanner input for imagefilepath input - linking to Runner class
	public String getImagePathName() {
		Scanner s = new Scanner(System.in);
		return s.next().strip();
	}

//scanner input for image output pathname - linking to Runner class
	public String getOutputPathName() {
		Scanner s = new Scanner(System.in);
		return s.next().strip();
	}

	public double[][] getFilterChoice() {
		// print filter options
		String menuOptions = String.join("\n", "Choose A Filter By Its Number ", "1: IDENTITY", "2: EDGE_DETECTION_1",
				"3: EDGE_DETECTION_2", "4: LAPLACIAN", "5: SHARPEN", "6: VERTICAL_LINES", "7: HORIZONTAL_LINES",
				"8: DIAGONAL_LINES", "9: BOX_BLUR", "10: SOBEL_HORIZONTAL", "11: SOBEL VERTICAL", "12: Exit");
		System.out.println(menuOptions);

		Scanner s = new Scanner(System.in);
		int choice = Integer.parseInt(s.next());

		// switch statement calling from kernel class which allows user to pick what
		// filter they want to use
		switch (choice) {
		case 1:
			return Kernel.IDENTITY;
		case 2:
			return Kernel.EDGE_DETECTION_1;
		case 3:
			return Kernel.EDGE_DETECTION_2;
		case 4:
			return Kernel.LAPLACIAN;
		case 5:
			return Kernel.SHARPEN;
		case 6:
			return Kernel.VERTICAL_LINES;
		case 7:
			return Kernel.HORIZONTAL_LINES;
		case 8:
			return Kernel.DIAGONAL_45_LINES;
		case 9:
			return Kernel.BOX_BLUR;
		case 10:
			return Kernel.SOBEL_HORIZONTAL;
		case 11:
			return Kernel.SOBEL_VERTICAL;
		case 12:
			System.out.println("Exiting");
			System.exit(1);
			return null;
		default:
			System.out.println("Invalid filter choice. Exiting");
			System.exit(1);
			return null;
		}
	}
}
