package ex09_this;

public class SchoolMain {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		student1.setStuNo("11025");
		student1.setName("전지현");

		Student student2 = new Student("11026", "정우성");
		
		School school = new School(2);  // ()안에 숫자 2를 입력하면 School 생성의 cnt로 전달. 
		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student1);
		school.printStudents();
		
	
		
	}

}
 