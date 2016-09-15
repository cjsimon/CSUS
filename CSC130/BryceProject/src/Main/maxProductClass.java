package Main;
public class maxProductClass {
	private int start;
	private int end;
	private int max;
	
	public maxProductClass(){
		start = 0;
		end = 0;
		max   = Integer.MIN_VALUE;
	}
	public maxProductClass(int startIndex, int endIndex) {
		start = startIndex;
		end = endIndex;
		max   = Integer.MIN_VALUE;
	}
	public maxProductClass(int startIndex, int endIndex, int maxFromDriver) {
		start = startIndex;
		end = endIndex;
		max   = maxFromDriver;
	}
	
	public int getStart(){
		return this.start;
	}
	public int getEnd(){
		return this.end;
	}
	public int getMax(){
		return this.max;
	}
	public void updateMax(int theMax){
		this.max = theMax;
	}
	public void updateStart(int theStart){
		this.start = theStart;
	}
	public void updateEnd(int theEnd) {
		this.end = theEnd;
	}
	
	public static maxProductClass maxP(int[] ARRAY, int start, int end) {
		int rightStart = 0, rightEnd = 0, leftEnd = 0, leftStart = 0, midStart = 0, midEnd = 0;
		int theEnd = 0, theStart = 0;
		
		if(start == end)
			return new maxProductClass(start, end, ARRAY[start]); //array[start]=max
		int center = (start + end) / 2;
		
		
		maxProductClass leftMaxSum = new maxProductClass();
		leftMaxSum = maxP(ARRAY, start, center);
		
		maxProductClass rightMaxSum = new maxProductClass();
		rightMaxSum = maxP(ARRAY, center + 1, end);
		
		
		//int leftSumofCrossinMiddle = 0, maxLeftCenterSum = 0;
		//leftSumofCrossinMiddle = maxLeftCenterSum = ARRAY[center];
		
		midStart = center;
		int leftSumofCrossinMiddle = 1, maxLeftCenterSum = Integer.MIN_VALUE;//-3245697
		//LEFT FOR
		for(int i = center; i >= start; i--) {
			leftSumofCrossinMiddle *= ARRAY[i];
			if(leftSumofCrossinMiddle > maxLeftCenterSum) {
				//leftMaxSum.updateMax(leftSumofCrossinMiddle);
				maxLeftCenterSum = leftSumofCrossinMiddle;
				midStart = i;
			}
		}//endFOR
		
		
		//int rightSumofCrossinMiddle = 0, maxRightCenterSum = 0;
		//rightSumofCrossinMiddle = maxRightCenterSum = ARRAY[center+1];
		
		midEnd = center + 1; //NEW
		int rightSumofCrossinMiddle = 1, maxRightCenterSum = Integer.MIN_VALUE;
		// RIGHT FOR
		for(int i = center + 1; i <= end; i++) {
			rightSumofCrossinMiddle *= ARRAY[i];
			if(rightSumofCrossinMiddle > maxRightCenterSum) {
				//rightMaxSum.updateMax(rightSumofCrossinMiddle);
				maxRightCenterSum = rightSumofCrossinMiddle;
				//theStart = center+1; theEnd = i;
				midEnd = i; //->New should work
			}
		}//endFOR
		int maxCenterSum = maxLeftCenterSum * maxRightCenterSum;
		if(maxLeftCenterSum > maxCenterSum) {
			maxCenterSum = maxLeftCenterSum;
		}
		if(maxRightCenterSum > maxCenterSum) {
			maxCenterSum = maxRightCenterSum;
		}
		
		// find maximum values of the three spans
		//int max = maxInt(leftMaxSum, rightMaxSum, maxCenterSum);
		int theMax = maxCenterSum;
		theStart = midStart;
		theEnd = midEnd;
		if(leftMaxSum.getMax() > theMax) {
			theMax = leftMaxSum.getMax();
			theStart = leftMaxSum.getStart();
			theEnd = leftMaxSum.getEnd();
		}
		if(rightMaxSum.getMax() > theMax) {
			theMax = rightMaxSum.getMax();
			theStart = rightMaxSum.getStart();
			theEnd = rightMaxSum.getEnd();
		}
		
		System.out.println("  theStart: " + theStart + "  theEnd: " + theEnd + " theMax " + theMax);
		
		//return max;
		return new maxProductClass(theStart, theEnd, theMax);
	}
}