// Data type for the Employee objects/arrays
class Employee {
	int id;
	String fname;
	String lname;
	int salary;
	float exp;
	String designation;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public float getExp() {
		return exp;
	}
	public void setExp(float exp) {
		this.exp = exp;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	// Instantiate with all properties
	public Employee(
		int id, 
		String fname, 
		String lname, 
		int salary, 
		float exp, 
		String designation
	) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.exp = exp;
		this.designation = designation;
	}
	
	// inst with just the ID
	public Employee(int id) {
		this.id = id;
	}
	
	// for console output
	@Override
	public String toString() {
		return "#" + id + " First Name: " + fname
				+ " last name: " + lname
				+ " salary: " + salary
				+ " exp: " + exp
				+ " designation: " + designation
				+ "\n";
	}
	
	
}