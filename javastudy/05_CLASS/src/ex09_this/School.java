package ex09_this;

public class School {

	// 필드
	private Student[] students;    // 현재, 아직 배열이 만들어지지 않은 상태
	private int idx;			   // students 배열의 인덱스. students 배열에 저장된 학생 수와 같다.
	
	// 생성자
	public School(int cnt) {
		students = new Student[cnt];  //SchoolMain new School ()에 입력해서 cnt로 전달 받은 숫자 만큼 학생을 만들 수 있다.
	}
	
	// 메소드
	public void addStudent(Student student) {    //school.addStudent(student1);가 좌측 배열 0에 들어감.
		if(idx == students.length) {
			System.out.println("Full");
			return;								// 하기 문을 실행하지 않음.
		}
		students[idx++] = student;           //계속 증가가 필요하기 때문에 idx++를 통해 입력
	
	}
	
	public void printStudents() {
		/* 일반 for문
		for(int i = 0; i < idx; i++) {         //학생수가 0보다 작으면 돌아가지 않기 때문에 idx를 사용해줌.
			System.out.println(students[i].getName() + ", " + students[i].getStuNo());
		}
		*/
		
		//향상 for문 (반드시 null체크를 해야함)
		for(Student student : students) {
			if(student != null) {
				System.out.println(student.getName() + ". " + student.getStuNo());				
		}
	}
	
	}
	
}
