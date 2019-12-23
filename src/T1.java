import java.util.Arrays;
import java.util.Scanner;


public class T1 {
	
	public static Employee[] employees;
	
	static Scanner s = new Scanner(System.in); 

	public static void main(String[] args) {
		
		// ask for how many employees the user wants to store
		System.out.println("Please enter how many employees you want to add: \n");
		
		int numEmployees = s.nextInt(); // the number of employees defined by the user, minimum 1
		
		if(numEmployees < 1) {
			System.out.println("The minimum number of employees I can store is 1. Aborting...");
		} else {
			
//			now we do stoff
			
			// initiate an array of employees based on the number input
			// the array is full of Employee objects
			employees = new Employee[numEmployees]; 
			
			System.out.print("Alright! I'm going to ask you for information regarding all employees. Please provide them below: \n");
			
			
			for(int i = 0; i < numEmployees; i++) {
				employees[i] = new Employee(i);

				System.out.println("Please enter Employee #" + i + "'s firstname:");
				employees[i].setFname(s.next());
				
				System.out.println("Please enter Employee #" + i + "'s lastname:");
				employees[i].setLname(s.next());
				
				System.out.println("Please enter Employee #" + i + "'s salary:");
				employees[i].setSalary(s.nextInt());
				
				System.out.println("Please enter Employee #" + i + "'s experience (years, decimal):");
				employees[i].setExp(s.nextFloat());
				
				System.out.println("Please enter Employee #" + i + "'s designation:");
				employees[i].setDesignation(s.next());
				
				System.out.print("Employee Info: " + employees[i].toString());
				
			}
			
			// all done
			// now offer options
			displayPrompt();
			
			
		}
		

	}
	
	public static void displayPrompt() {
		// 1: List all employees
		// 2: Sort by Salary - ASC
		// 3: Sort by Salary - DESC
		// 4: Sort by fname - ASC
		System.out.println("\n Please enter a number to display specific list of employees.\n"
				+ "Total Employees: " + employees.length + "\n"
				+ "1: List All Employees \n"
				+ "2: List Employees by Salary - ASC \n"
				+ "3: List Employees by Salary - DESC \n"
				+ "4: List Employees by Firstname - ASC \n"
				);
		
		int command = s.nextInt();
		switch (command) {
			case 1:
				displayList(employees, "List of all employees:");
				break;
				
			case 2:
				sortBy("salary", "asc");
				break;
				
			case 3:
				sortBy("salary", "DESC");
				break;
				
			case 4:
				sortBy("fname", "asc");
				break;
	
			default:
				displayPrompt();
				break;
		}
	}
	
	public static void sortBy(String column, String order) {
		
		// acceptable columns: salary, fname
		// acceptable orders: ASC or DESC 
		// not case sensitive
		
		order = order.toLowerCase();
		column = column.toLowerCase();
		
		// time to process them
		System.out.println("Please wait...");
		
		Employee[] originalList = employees.clone(); 
		
		if(column == "fname") {
			Arrays.sort(originalList, (a,b) -> a.fname.compareTo(b.fname));
		} else {
			// the other choice is salary so no need to do an else if
			
			if(order == "asc") {
				Arrays.sort(originalList, (a,b) -> Integer.compare(a.getSalary(), b.getSalary()));
			} else {
				Arrays.sort(originalList, (a,b) -> Integer.compare(b.getSalary(), a.getSalary()));
			}
		}
		
		displayList(originalList, "Employees ordered by " + column.toUpperCase() + " - " + order.toUpperCase());
		
		
	}
	
	public static void displayList(Employee[] list, String msg) {
		System.out.print("----------");
		System.out.print(msg.toUpperCase());
		System.out.print("----------");
		
		// deepToString goes thru all children and uses their toString()
		System.out.println(Arrays.deepToString(list)); 
		
		System.out.print("\n");
		displayPrompt();
	}

}
