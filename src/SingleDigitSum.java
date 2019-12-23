import java.util.Scanner;

public class SingleDigitSum {

	public static void main(String[] args) {
		int numbersToInput = 3; // how many numbers to take
		int[] numbers = new int[numbersToInput]; // numbers array
		int sum = 0; // we store the sum here
		
		// initialize scanner
		Scanner s = new Scanner(System.in);
		
		// hint
		System.out.println("Please enter " + numbersToInput + " numbers:");
		
		for (int i = 0; i < numbersToInput; i++) {
			numbers[i] = s.nextInt();
		}
		
		s.close();
		
		// step 1: get the initial sum
		sum = arrayToSum(numbers);
		
		// step 2, while the sum is more than 10 ( not a single digit)
		// keep doing sum to array, then array to sum
		while (sum > 10) {
			int[] array = sumToArray(sum); // turn the number 'sum' into an array
			sum = arrayToSum(array); // sum up the array, this continues the loop till it's less than 10 (single digit)
		}
		
		System.out.println("The single digit sum is: " + sum);
		
	}
	
	/**
	 * Turns a number into an array
	 * @param sum int
	 * @return int[]
	 */
	public static int[] sumToArray(int sum) {
		String sumToString = String.valueOf(sum);
		int length = sumToString.length();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = sumToString.charAt(i) - '0';
		}
		
		return array;
	}
	
	/**
	 * Sums up an array of numbers
	 * @param array int[]
	 * @return int
	 */
	public static int arrayToSum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

}
