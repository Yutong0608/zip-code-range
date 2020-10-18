package main;

import java.util.*;
import java.util.List;

public class ZipCode {
	public static List<List<Integer>> merge(List<List<Integer>> zipRange) {
		List<List<Integer>> changed = new LinkedList<>();
		if (zipRange == null || zipRange.size() == 0) {
			return changed;
		}
		zipRange.sort((i1, i2) -> Integer.compare(i1.get(0), i2.get(0)));
		List<Integer> begin = zipRange.get(0);
		int start = begin.get(0);
		int end = begin.get(1);
		for (List<Integer> zip : zipRange) {
			if (zip.get(0) <= end) {
				end = Math.max(end, zip.get(1));
			} else {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(start);
				tmp.add(end);
				changed.add(tmp);
				start = zip.get(0);
				end = zip.get(1);
			}
		}
		List<Integer> tmp = new ArrayList<>();
		tmp.add(start);
		tmp.add(end);
		changed.add(tmp);
		return changed;
	}
}
