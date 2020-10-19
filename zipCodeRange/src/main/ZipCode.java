package main;

import java.util.*;
import java.util.List;

public class ZipCode {
	public static List<Range> merge(List<Range> zipRange) {
		List<Range> result = new ArrayList<>();
		if (zipRange == null || zipRange.size() == 0) {
			return result;
		}
		// sort as the ascending order of the lower bound
		Collections.sort(zipRange, new SortByLower());
		Range begin = zipRange.get(0);
		int lower = begin.getLower();
		int upper = begin.getUpper();
		for (Range zip : zipRange) {
			// overlapping ranges, move the upper bound if needed
			if (zip.getLower() <= upper) {
				upper = Math.max(upper, zip.getUpper());
			} else { // disjoint ranges
				result.add(new Range(lower, upper));
				lower = zip.getLower();
				upper = zip.getUpper();
			}
		}
		result.add(new Range(lower, upper));
		return result;
	}
}
