import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class SelectionSortTests {

	@Test
	public void works() {
	    int[] actual = { 20, 13, 86, 69, 3, 1 };
	    int[] expected = { 1, 3, 13, 20, 69, 86 };
	    assertArrayEquals(expected, SelectionSort.selectionSort(actual));
	}
	
	@Test
	public void worksTwo() {
	    int[] actual = new int[100];
	    
	    for (int i = 0; i < actual.length; i++) {
	    	actual[i] = new Random().nextInt(100);
	    }
	    
	    int[] expected = SelectionSort.selectionSort(actual);
	    Arrays.sort(actual);
	    
	    assertArrayEquals(actual, expected);
	}
	
	@Test
	public void worksThree() {
		
	    int[] actual = new int[0];
	    
	    int[] expected = SelectionSort.selectionSort(actual);
	    
	    assertArrayEquals(actual, expected);
	}
	
	@Test
	public void worksFour() {
		
	    int[] actual = new int[] {5};
	    
	    int[] expected = SelectionSort.selectionSort(actual);
	    
	    assertArrayEquals(actual, expected);
	}
	
}
