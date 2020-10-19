package main;

import java.util.ArrayList;
import java.util.List;

public class ZipCodeProcessor {
	public ZipCodeProcessor() {

	}

	public List<Range> getRangeList(String zipcodeRanges) {
		String[] zipcodeIntervals = zipcodeRanges.split(" ");
		List<Range> zipcodesList = new ArrayList<>();
		for (int i = 0; i < zipcodeIntervals.length; i++) {
			zipcodesList.add(getValidZipcodeRange(zipcodeIntervals[i]));
		}
		return zipcodesList;
	}

	public Range getValidZipcodeRange(String zipcodeRange) {
		return validate(zipcodeRange.replaceAll("\\[|\\]", "").split(","));
	}
	
	public Range validate(String[] zipRange) {
		if (zipRange.length != 2) {
			throw new IllegalArgumentException("Illegale Zipcode Bound Number");
		}
		int lower = Integer.parseInt(zipRange[0]);
		int upper = Integer.parseInt(zipRange[1]);
		if (upper < 0 || lower < 0) {
			throw new IllegalArgumentException(upper + " " + upper + ": " + "Illegale Zipcode, Must be Positive");
		}
		Range zipcode = null;
		if (validateRange(lower, upper)) {
			zipcode = new Range(lower, upper);
		}
		return zipcode;
	}
	
	public boolean validateRange(int lower, int upper) {
		if (lower / 10000 < 1 || upper / 1000 < 1) {
			throw new IllegalArgumentException(upper + " " + upper + ": " + "Illegale Zipcode Digit");
		}
		if (lower > upper) {
			throw new IllegalArgumentException(lower + " " + upper + ":  " + "Illegale Zipcode Range");
		}
		return true;
	}
}
