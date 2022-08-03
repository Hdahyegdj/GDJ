package quiz08_schedule;

import java.util.Scanner;

public class WeekScheduler {
	
	private int nthWeek; 	// 1 ~ n주차
	private Day[] week;		// 여기서 호출하는 건 for문에 week.length임.
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};		// 일 = 0 ... 수 = 3
	private Scanner	sc;	 	// java.util package
	
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		week = new Day[7];
		sc = new Scanner(System.in);
	}

	private void makeSchedule() {		// public -> private로 변경 : 외부에서 불필요하게 메소드를 호출할 필요가 사라짐.
		System.out.println("=== 등록 ===");
		System.out.print("요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);		// 요일 값만 가져감(ex) 수요일 -> 수), 별도 enter값을 없애줘야함. // '월요일'이라 입력했을때 월만 가져오기 위해 substring를 사용(equals를 쓰기 때문에)
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {		// 여기서 i는 해당 요일의 번호
				if(week[i] == null) { 	// 등록된 스케줄이 없으면	//week[i]에 스케줄을 넣어야함.
					System.out.println("스케줄 입력 >>>");
					String schedule = sc.nextLine(); 	// 스케줄에 공백 입력이 가능함.
					Day day = new Day();
					day.setSchedule(schedule);
					week[i] = day;  
					System.out.println(dayName + "요일에 새 스케줄이 등록되었습니다.");
				} else {
					System.out.println(dayName + "요일은 이미 스케줄이 있습니다.");
				}
				return;		// if, else 후에 하단으로 내려가면 안됨.
			}	
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");  	// 없는 요일 입력했을떄, for문 밖에 만들어줘야함.	
	}
	
	private void changeSchedule() {
		System.out.println("=== 수정 ===");
		
		
		System.out.println("변경할 요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println(dayName + "요일은 스케줄이 없습니다.");
					System.out.println("새 스케줄을 등록할까요?(y/n)? >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.println("새 스케줄 입력 >>> ");
						String schedule = sc.nextLine();
						Day day = new Day();
						day.setSchedule(schedule);
						week[i] = day;
						System.out.println(dayName + "요일의 스케줄이 변경되었습니다.");
					} else {
						System.out.println("스케줄 변경이 취소되었습니다.");
					}
				} else {
					System.out.println(dayName + "요일의 스케줄은 " + week[i].getSchedule() + "입니다.");
					System.out.println("변경할까요?(y/n) >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.println("변경할 스케줄 입력 >>> ");
						String schedule = sc.nextLine();
						week[i].setSchedule(schedule);
						System.out.println(dayName + "요일의 스케줄이 변경되었습니다.");
					} else {
						System.out.println("스케줄 변경이 취소되었습니다.");
					}
				}
			}
			return;
		}
			
		
	}
	
	private void deleteSchedule() {
		System.out.println("=== 삭제 ===");
		System.out.println("삭제할 요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();			// 남은 enter 처리
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println(dayName + "요일은 스케줄이 없습니다.");
				} else {
					System.out.println(dayName + "요일의 스케줄은 " + week[i].getSchedule() + "입니다.");
					System.out.println("삭제할까요(y/n)? >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {    //y 대소문자 상관없이 yes로 인식
						week[i] = null;
						System.out.println(dayName + "요일의 스케줄이 취소되었습니다.");						
					} else {
						System.out.println("스케줄 삭제가 취소되었습니다.");
					}
				}
				return; 
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	}
	
	private void printWeekSchedule() {
		System.out.println("=== 전체조회 ===");
		System.out.println(nthWeek + "주차 스케줄 안내");
		for(int i = 0; i < week.length; i++) {
			System.out.print(dayNames[i] + "요일 - ");
			System.out.println(week[i] == null ? "X" : week[i].getSchedule());
		}
	}
	
	public void manage() {
		
		while(true) {		// 무한루프
			System.out.print("1.등록 2.수정 3.삭제 4.전체조회 0.종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1: makeSchedule(); break;
			case 2: changeSchedule(); break;
			case 3: deleteSchedule(); break;
			case 4: printWeekSchedule(); break;
			case 0: System.out.println("스케줄러를 종료합니다."); return;
			default : System.out.println("인식할 수 없는 명령입니다.");
			}
		}
	}
}
