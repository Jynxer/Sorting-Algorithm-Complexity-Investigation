import java.awt.Point;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		
		Point[] runTimes = new Point[100];
		int[] x = new int[100];
		int[] y = new int[100];
		
		for (int a = 0; a < 100; a++) {
			
			int[] test = new int[a + 1];
			
			/*
			for (int b = 0; b < test.length; b++) {
				
				test[b] = new Random().nextInt(100);
				
			}
			*/
			
			for (int b = test.length - 1; b >= 0; b--) {
				test[b] = b;
			}
			
			runTimes[a] = new Point(a + 1, Math.toIntExact(run(test)));
		}
		
		System.out.println("Runtimes:");
		
		for (int i = 0; i < runTimes.length; i++) {
			
			x[i] = (int) runTimes[i].getX();
			y[i] = (int) runTimes[i].getY();
			System.out.println("Array size = " + Integer.toString(x[i]) + ", runtime = " + Integer.toString(y[i]) + " nanoseconds");
			//System.out.println(Integer.toString(y[i]));
			
		}
		
	}
	
	public static long run(int[] array) {
		
		long start = System.nanoTime();
		int[] sorted = mergeSort(array);
		long runTime = System.nanoTime() - start;
		
		return(runTime);
		
	}
	
	public static int[] mergeSort(int[] initialSet) {
		
		return(divide(initialSet));
		
	}
	
	public static int[] conquer(int[] left, int[] right) {
		
		int[] temp = new int[left.length + right.length];
		int halfSize = temp.length / 2;
		int i = 0, leftCounter = 0, rightCounter = 0;
		
		while ((leftCounter < halfSize) && (rightCounter < (temp.length - halfSize))) {
			
			if (left[leftCounter] <= right[rightCounter]) {
				
				temp[i] = left[leftCounter];
				i++;
				leftCounter++;
				
			} else {
				
				temp[i] = right[rightCounter];
				i++;
				rightCounter++;
				
			}
			
		}
		
		while (leftCounter < halfSize) {
			
			temp[i] = left[leftCounter];
			i++;
			leftCounter++;
			
		}
		
		while (rightCounter < (temp.length - halfSize)) {
			
			temp[i] = right[rightCounter];
			i++;
			rightCounter++;
			
		}
		
		return(temp);
		
	}
	
	public static int[] divide(int[] set) {
		
		int size = set.length;
		int midpoint = size / 2;
		int[] left = new int[midpoint];
		int[] right = new int[size - midpoint];
		
		if (size <= 1) {
			
			return(set);
			
		}
		
		for (int i = 0; i < midpoint; i++) {
			
			left[i] = set[i];
			
		}
		
		for (int i = midpoint; i < size; i++) {
			
			right[i - midpoint] = set[i];
			
		}
		
		left = divide(left);
		right = divide(right);
		
		return (conquer(left, right));
		
	}

}
