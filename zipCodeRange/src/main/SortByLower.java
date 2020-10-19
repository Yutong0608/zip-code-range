package main;

import java.util.Comparator;

public class SortByLower implements Comparator<Range> {
	public int compare(Range a, Range b) {
		return a.getLower() - b.getLower();
	}
}
