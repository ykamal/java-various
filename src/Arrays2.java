import java.util.Scanner;
import java.util.stream.IntStream;


public class Arrays2 {
	public static void main(String[] args) {
		Integer largest;
		Integer smallest;
		Integer largeindex;
		Integer smallindex;
		Integer sln;
		Integer ssn;
		Integer slni;
		Integer ssni;
		Integer size;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter Size");
		size = s1.nextInt();
		int[] array = new int[size];
		System.out.println("Enter elements of your array one by one");
		Integer n = 0;
		while (n <= size - 1) {
			array[n] = s1.nextInt();
			n++;
		}

		largest = 0;
		sln = 0; // 2nd largest number
		slni = 0; // 2nd largest number index
		largeindex = 0;
		
		// we assign the indexes at the very end. 
		// first we find the entries
		
		// largest and 2nd largest
		for (int i = 0; i < size; i++) {
			if (largest < array[i]) {
				// find the largest number
				sln = largest;
				largest = array[i];
			} else if (sln < array[i]) {
				// 2nd largest
				// only triggered when numbers are entered at random
				sln = array[i];		
			}

		}

		// smallest and 2nd smallest
		smallest = Integer.MAX_VALUE;
		ssn = Integer.MAX_VALUE; // 2nd smallest number
		smallindex = 0;
		ssni = 0; // 2nd smallest number index
		
		// like before, no index finding yet
		for (int i = 0; i < size; i++) {
			if (array[i] < smallest) {
				ssn = smallest;
				smallest = array[i];
				
			} else if (array[i] < ssn) {
				ssn = array[i];
				
			}
		}
		
		
		// now to find indexes
		largeindex = findIndex(array, largest);
		slni = findIndex(array, sln);
		smallindex = findIndex(array, smallest);
		ssni = findIndex(array, ssn);

		System.out.println("The largest Number is " + largest + " index is  " + largeindex);
		System.out.println("The smallest Number is " + smallest + " index is  " + smallindex);
		System.out.println("The 2nd largest Number is " + sln + " index is  " + slni);
		System.out.println("The 2nd smallest Number is " + ssn + " index is  " + ssni);
		s1.close();
	}
	
	/**
	 * Find the index of an item inside a given array
	 * @param a array
	 * @param target int
	 * @return
	 */
	public static int findIndex(int[] a, int target) {
		return IntStream.range(0, a.length).filter(i -> a[i] == target).findFirst().orElse(-1);
		
	}
}