package ex02_datetime;

import java.util.Calendar;

public class Ex04_calendar {

	public static void main(String[] args) {
		
		// calendar 클래스
		// 현재 날짜 또는 특정 날짜를 나타낼 때 사용
		// 날짜의 특정 요소(년, 월, 일, 시, 분, 초 ...)를 쉽세 사용
		
		Calendar cal = Calendar.getInstance();                   //반드시, .다음 목록에서 선택(상단의 import를 불러오기 위해)
		//------ --- 
		//ㄴclass(twpe) ㄴ객체(object)                                // int a; 에서 int(type): 기본 8개 타입 외는 전부 클래스, a(variable)
		
		//년, 월, 일, 요일
		int year = cal.get(Calendar.YEAR);   // int year = cal.get(1);    // 클래스에 포함 되어 있으면 메소드(. 뒤에 오는 모든 자동완성), 그 외는 함수(자바에서는 대부분 메소드)
		int month = cal.get(Calendar.MONTH) + 1;   	 // cltr 클릭한 채로 상단 중간 Calendar 클릭해서 짜여진 내용 확인 가능(상수값 불러 사용), (javadoc : 인터넷에 표시되는 글자, 시작:/** .... 끝 : */)
		int day = cal.get(Calendar.DAY_OF_MONTH);    //해당 월의 일 표시
        int weekNo = cal.get(Calendar.DAY_OF_WEEK); 	//일주일 중 몇 번째 요일 표시
        
        
        System.out.println(year);
        System.out.println(month);            //월 : 0~11로 표시, 한달 밀려서 표시 됨.(현재 7월이나 표시 값은 8), +1를 추가 기입
        System.out.println(day);
        
        switch(weekNo) 	{
        case 1 : System.out.println("일요일"); break;
        case 2 : System.out.println("월요일"); break;
        case 3 : System.out.println("화요일"); break;
        case 4 : System.out.println("수요일"); break;
        case 5 : System.out.println("목요일"); break;
        case 6 : System.out.println("금요일"); break;
        default : System.out.println("토요일");
        }
        
        System.out.println(weekNo);           //일요일 = 1, 월요일 = 2, ... , 토요일 = 7
      
		// 오전/오후, 시, 분, 초 
        int ampm = cal.get(Calendar.AM_PM);    // 오전(0), 오후(1)
        int hour12 = cal.get(Calendar.HOUR);	// 시(1 ~ 12)
        int hour24 = cal.get(Calendar.HOUR_OF_DAY);   // 시(0 ~ 23)
        int minute = cal.get(Calendar.MINUTE);    // 분(0 ~ 59)
        int second = cal.get(Calendar.SECOND);    // 초(0 ~ 59)
        
        switch(ampm) {
        case 0 : System.out.println("오전"); break;
        case 1 : System.out.println("오후"); break;
        }
        System.out.println(hour12);
        System.out.println(hour24);
        System.out.println(minute);
        System.out.println(second);
        
        //timestamp
        long timestamp = cal.getTimeInMillis();
        System.out.println(timestamp);
        	 
		
		
		

	}

}
