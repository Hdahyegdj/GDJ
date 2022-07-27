package ex02_field;

public class SchoolMain {

	public static void main(String[] args) {
		
		School school = new School();
		school.name = "경인중학교";
		
		Student student1 = new Student();   //학생 1명 만들기
		student1.stuNo = "11025"; 
		student1.name = "전지현";

		Student student2 = new Student();
		student2.stuNo = "11026";
		student2.name = "정우성";
		
		school.students[0] = student1;   //등록
		school.students[1] = student2;
		
		for(int i = 0; i < school.students.length; i++) {	 //출력
			System.out.println(school.students[i].stuNo);    //여기까지가 학생 1명, 타입은 student   //students는 배열임.(배열은 index i와 for문이 함께함.)
			System.out.println(school.students[i].name);

	}

}
}
