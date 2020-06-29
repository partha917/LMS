package com.parthad.main;

public class FormatOP {

	public static String formatSpace(String str,int length) {

		String padded = String.format("%-" + length + "." + length + "s", str);
		return padded;
	}

	public static void formatHeaderSpace(String str, int length) {
		System.out.print(String.format("%-" + length + "." + length + "s", str));
	}

	public static void formatUnderLine(int length) {
		System.out.print(String.format("%" + length + "s", "_").replace(' ', '_'));
	}

	public static void printHeader(String[] toPrint,int length) {

		for (int i = 0; i < toPrint.length; i++) {
			formatUnderLine(20);
		}
		System.out.println();
		for (int i = 0; i < toPrint.length; i++) {
			formatHeaderSpace((String) toPrint[i], length);
		}
		System.out.print("|");
		System.out.println();
		for (int i = 0; i < toPrint.length; i++) {
			formatUnderLine(20);
		}
		System.out.print("|");
		System.out.println();
		System.out.println();
	}

	public static void printData(Object[] toPrint,int length) {
		for (int i = 0; i < toPrint.length; i++) {
			System.out.print(String.format("%-" + length + "." + length + "s", toPrint[i]));
		}
		System.out.println();
	}

	public static void printDisplayBoard(String[] toPrint) {
		int length = 36;
		int count = 0;
		int k = 1;
		System.out.println();
		printUnderLine();
		for (int i = 0; i < toPrint.length; i++) {
			count += length;
			if (count > 180 ) {
				formatHeaderSpace((String) toPrint[i], length);
				System.out.println();
				count=0; 
				continue;
			}
			formatHeaderSpace((String) toPrint[i], length);

		}
		System.out.println();
		printUnderLine();
		System.out.println();
	}
	public static void printUnderLine() {
		for (int i = 0; i < 211; i++) {
			System.out.print("_");
		}
		System.out.println();
		
	}

}
