

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class InputOutput {

	private Scanner x;
	PrintWriter output;

	public void openFiles() {
		try {
			x = new Scanner(new File("pol"));
		} catch (Exception e) {
			System.out.println("Couldn't find the input file.");
		}
		try {
			output = new PrintWriter(new File("output"));
		} catch (Exception e) {
			System.out.println("The output file couldn't be created.");
		}
	}

	public int[] readCoefficients() {

		int i = 0;
		String s = x.nextLine();
		String[] coeffs = s.split(" ");
		int[] coefficients = new int[coeffs.length];

		for (i = 0; i < coeffs.length; i++) {
			coefficients[i] = Integer.parseInt(coeffs[i]);
		}
		return coefficients;
	}

	public String[] readCommands() {
		int i = 0;
		String command[] = new String[20];
		while (x.hasNextLine()) {
			command[i] = x.nextLine();
			i++;
		}
		return command;
	}

	public void writingFile(String proposition) {
		output.println(proposition);
	}

	public void closeFile() {
		x.close();
		output.close();
	}

}
