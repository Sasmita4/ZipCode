package com.zip.range;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*
 *Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), 
 *program that produces the minimum number of ranges required to represent the same restrictions as the input.  
 */

public class ZipCodeRangeMain {
	private static List<ZipCodeRange> minimalZipCodeRangeList = new ArrayList<ZipCodeRange>();

	/**
	 * @param ZipCodeRange model This method is to add the range into the minimum
	 *  range list by comparing the existing element of the list
	 *  with the newly added range.
	 */
	public void addToMinimalRange(ZipCodeRange range) {
		int needToAddRange = 0;
		if (minimalZipCodeRangeList.size() == 0) {
			minimalZipCodeRangeList.add(range);
		} else {
			ListIterator<ZipCodeRange> it = minimalZipCodeRangeList.listIterator();
			boolean flag = true;
			needToAddRange = 0;
			while (it.hasNext()) {
				ZipCodeRange zcr = it.next();
				if (zcr.getLowerBound() <= range.getLowerBound() && zcr.getUpperBound() <= range.getUpperBound()) {
					if (zcr.getLowerBound() <= range.getLowerBound() && range.getLowerBound() > zcr.getUpperBound()) {
						needToAddRange = 1;
					} else {
						needToAddRange = 0;
						zcr.setUpperBound(range.getUpperBound());
					}
				} else if (zcr.getLowerBound() > range.getUpperBound() || zcr.getUpperBound() < zcr.getLowerBound()) {
					flag = true;
				} else {
					if (zcr.getLowerBound() < range.getLowerBound())
						range.setLowerBound(zcr.getLowerBound());
					if (zcr.getUpperBound() > range.getUpperBound())
						range.setUpperBound(zcr.getUpperBound());
					it.remove();
					flag = true;
				}
			}
			if (needToAddRange == 1)
				flag = true;
			else
				flag = false;

			if (flag)
				minimalZipCodeRangeList.add(range);
		}
	}

	/**
	 * To display the minimum number of ranges required
	 */
	public void displayRange(List<ZipCodeRange> range) {
		Iterator<ZipCodeRange> it = range.iterator();
		while (it.hasNext()) {
			ZipCodeRange zcr = it.next();
			System.out.println(zcr.toString());
		}
	}

	public static void main(String[] args) {
		ZipCodeRangeMain zipCodeRangeManin = new ZipCodeRangeMain();
		List<ZipCodeRange> zipCodeRangeList = new ArrayList<>();

		System.out.println("********Enter the ranges*******");
		String c = "y";

		Scanner sc = new Scanner(System.in);
		// To take input from console
		while (c.equalsIgnoreCase("y")) {
			System.out.println("Enter lowerbound");
			int lowerbound = sc.nextInt();
			System.out.println("Enter upperbound");
			int upperbound = sc.nextInt();
			ZipCodeRange zipCodeRange = new ZipCodeRange(lowerbound, upperbound);
			zipCodeRangeList.add(zipCodeRange);
			System.out.println("Do you want to enter more ranges..press y/n to continue");
			c = sc.next();
		}
		
		sc.close();
		System.out.println("Original range:");
		    zipCodeRangeManin.displayRange(zipCodeRangeList);
		for (ZipCodeRange zcr : zipCodeRangeList) {
			zipCodeRangeManin.addToMinimalRange(zcr);
		}
		System.out.println("Minimized range:");
		zipCodeRangeManin.displayRange(minimalZipCodeRangeList);

	}
}
