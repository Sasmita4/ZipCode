package com.zip.range;

public class ZipCodeRange {
	private int lowerBound;
	private int upperBound;
	
	ZipCodeRange(int lowerBound,int upperBound){
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() 
	{
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	public String toString() {
		return "["+lowerBound+","+ upperBound+"]";
	}
}
