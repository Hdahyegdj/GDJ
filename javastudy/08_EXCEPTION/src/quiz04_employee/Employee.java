package quiz04_employee;

public class Employee {		// 추상메소드를 가졌기 때문에 추상클래스로 수정
	
	private int empNo;		// 사번
	private String name;
	
	public Employee(int empNo, String name) {
		super();
		this.empNo = empNo;
		this.name = name;
	}

	public int getEmpNo() {			// get&setter
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override		// toString
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name;
	}
	public abstract int getPay();
	
	

}
