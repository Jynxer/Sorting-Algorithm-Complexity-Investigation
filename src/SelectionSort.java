import java.util.Random;
import java.awt.Point;

public class SelectionSort {

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
		int[] sorted = selectionSort(array);
		long runTime = System.nanoTime() - start;
		
		return(runTime);
		
	}
	
	public static int[] update(int[] array, int one, int two) {
		
		int temp = array[two];
		array[two] = array[one];
		array[one] = temp;
		return(array);
		
	}
	
	public static int[] selectionSort(int[] set) {
		
		int size = set.length;
		
		for (int a = 0; a < size - 1; a++) {
			
			int min = a;
			
			for (int b = a + 1; b < size; b++) {
				
				if (set[b] < set[min]) {
					
					min = b;
					
				}
				
			}
			
			if (min != a) {
				
				set = update(set, a, min);
				
			}
			
		}
		
		return(set);
		
	}

}
