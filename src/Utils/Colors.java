package utils;

public class Colors {
	public static final String LIGHT_BLUE = "\033[1;34m";
	public static final String PURPLE = "\033[35m";
	public static final String RED = "\033[31m";
	public static final String RESET = "\u001B[0m";

	public static void printBlue (Sring message) {
		System.out.println(LIGHT_BLUE + message + RESET);
	}

	public static void printPurple (Sring message) {
		System.out.println(PURPLE + message + RESET);
	}

	public static void printRed (Sring message) {
		System.out.println(RED + message + RESET);
	}	
}