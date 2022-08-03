package ex06_constructor;

public class StudentMain {

	public static void main(String[] args) {
		
		Student student = new Student("tom", "goodee");
		
		System.out.println(student.getName());     //ctrl + space로 getName 확인하여 입력
		System.out.println(student.getSchool());
		
		Alba alba = new Alba("jesica", "seoul univ", "library");
		System.out.println(alba.getName());
		System.out.println(alba.getSchool());
		System.out.println(alba.getCompany());
	}

}
