package quiz04_employee;

public class Regular extends Employee {
	
	private int salary;
							
	public Regular(int salary, String name, int salary) {			// 생성자
		super(empNo, name);
		this.salary = salary;
	}

	
	@Override					// toString
	public String toString() {
		return super.toString() + ", salary=" + salary + "]";
	}

	@Override
	public int getPay() {
		return salary; 		// 정규직은 salary가 월급
	}
	
	
	


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
