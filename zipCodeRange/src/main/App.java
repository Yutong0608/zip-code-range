package main;

import java.util.List;
import java.util.Scanner;

public class App {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String zipcodeRanges = scan.nextLine();
		ZipCodeProcessor zipcodeProcessor = new ZipCodeProcessor();
		List<Range> zipcodeList = zipcodeProcessor.getRangeList(zipcodeRanges);
		List<Range> mergedZipcodeList = ZipCode.merge(zipcodeList);
		for (Range range : mergedZipcodeList) {
			System.out.println(range.toString());
		}
	}
}
