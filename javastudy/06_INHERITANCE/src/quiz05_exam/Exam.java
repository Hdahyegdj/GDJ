package quiz05_exam;

public class Exam {
	
	//먼저, 필드값을 지정.
	private String examName; // 여기에 중간고사가 저장됨.
	private int kor;
	private int eng;
	private int mat;
	
	public Exam(String examName) {		// 생성자 생성
		this.examName = examName;
	}

	public void setScore() {
		kor = (int)(Math.random() * 101); 	//0~100까지는 101개의 숫자가 존재
		eng = (int)(Math.random() * 101);
		mat = (int)(Math.random() * 101);
	}
	
	public void examinfo() {
		System.out.println(examName + " 성적");
		System.out.println("국어:" + kor + ", 영어:" + eng + ", 수학:" + mat);
		int total = kor + eng + mat;
		System.out.println("총점: " + total + ", 평균:" + (total / 3.0));
	}
	
	
	
	

}
