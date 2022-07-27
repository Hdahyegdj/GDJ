package ex03_string;

public class Ex01_String {
	       //클래스

	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "hello";
		
		/*
		str1 0x123
		str2 0x123
		
			hello 0x123
		*/
		System.out.println(str1 == str2); //true
		
		
		
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		/*
		str3 0x123
		str4 0x456     //각각 다른 String에 참조값으로 존재
		
			hi		0x123
			hi		0x456
		 */
		System.out.println(str3 == str4); //false       //문자열은 ==를 사용하면 안됨.

		
		// 1. 문자열 동등 비교
		boolean result1 = str1.equals(str2);        //메소드를 호출하여 실제 123번지에 저장된 문자열이 같은지 비교
		boolean result2 = str2.equals(str4);
		                //객체.매소드(주황색 글자)
		System.out.println(result1);
		System.out.println(result2);
		
		if(str1.equals(str2)) { 
			System.out.println("str1, str2는 같아요");
		} else {
			System.out.println("str1, str2는 달라요");
		}
	
		if(!str3.equals(str4)) {							//!은 "NOT" 이며, 반대됨.
			System.out.println("str3, str4는 달라요");
		} else {
			System.out.println("str3, str4는 같아요");
		}
	
		
		// 2. 대소문자를 무시한 문자열 동등 비교
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		
		System.out.println(str5.equals(str6));    //-> false. 단 한글자만 달라도 다르다고 판단.
		
		boolean result3 = str5.equalsIgnoreCase(str6);  
		System.out.println(result3);			  //->true. 대소문자 무시하고 비교.
		
		
		// 3. 문자열 길이 반환
		String name = "민경태";
		int length = name.length();
		System.out.println("글자수 : " + length);	//공란도 글자수에 포함.
		
		
		// 4. 특정 위치의 문자(char)만 반환
		// 특정 위치
		// 인덱스(Index)라고 함      )         // 'a' : char 타입. "a" : string 타입  -> 둘은 전혀 다름
		// 글자마다 부여된 정수값	 }
		// 0으로 시작				 )	 ->여기가 중요
		System.out.println(name.charAt(0));		// 첫번째 글자 0
		System.out.println(name.charAt(1));	
		System.out.println(name.charAt(2));	
		
		
		// 5. 문자열의 일부 문자열(String)을 반환		//중요
		// 	1) substring(begin) : 인덱스 begin(포함)부터 끝까지 반환
		// 	2) substring(begin, end) : 인덱스 begin(포함)부터 인텍스 end(불포함)까지 반환
		// ex) substring(0, 1) -> 0만 표시됨.
		System.out.println(name.substring(0, 1));
		System.out.println(name.substring(1));
		
		
		// 6. 특정 문자열을 찾아서 해당 인덱스(int)를 반환
		// 	1) indexOf
		//		(1) 발견된 첫 번째 문자열의 인덱스를 반환
		//		(2) 발견된 문자열이 없는 경우 -1을 반환
		//	2) lastIndexOf
		//		(1) 발견된 마지막 문자열의 인덱스를 반환
		//		(2) 발견된 문자열이 없는 경우 -1을 반환
		int idx1 = name.indexOf("민");		//변수 이름 : idx = 인덱스, 동일한 값이 반복 될때 첫번째 글자로 표시
		int idx2 = name.indexOf("경태");
		int idx3 = name.lastIndexOf("민");
		int idx4 = name.lastIndexOf("경태");
		System.out.println(idx1);      
		System.out.println(idx2);
		System.out.println(idx3);
		System.out.println(idx4);
		
		
		// 7. 문자열이 특정 패턴으로 시작하는지 boolean(true, false) 반환
		//	  startWith(문자열)
		if(name.startsWith("민")) {
			System.out.println("민씨입니다.");
		} else {
			System.out.println("민씨가 아닙니다");
		}
		
		
		// 8. 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		//	  endWith(문자열)
		String filename = "image.jpg";	 // jpg, png로 끝나면 이미지로 가정
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지 입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		}
		
		
		// 9. 문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		String email = "dh.han@gmail.com";
		if(email.contains("@") && email.contains((".")) ) {
			System.out.println("이메일 입니다.");
		} else {
			System.out.println("이메일이 아닙니다.");
		}
		
		
		// 10. 불필요한 공백 제거(좌우 공백)
		String message = "  안녕  하세요  ";
		            //대상--            --
		System.out.println(message.trim());
		System.out.println(message.trim().length());
		
		
		// 11. 대소문자 변환하기 -> 변환시켜도 source는 변하지 않음.
		// toUpperCase() : 대문자로 변환하기
		// tpLowerCase() : 소문자로 변환하기
		String source = "best of best";
		System.out.println(source.toUpperCase());
		System.out.println(source.toLowerCase());
		
		
		// 12. 찾아 바꾸기
		// replace(old, new) : old를 찾아 new로 변환하기 -> replace시켜도 source는 변하지 않음.
		String replaced = source.replace("best", "worst");
		System.out.println(source);
		System.out.println(replaced);
		
		// 주의. replacedAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.\
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "_"); //192_168_101_91을 기대(replace로 입력하면 원하는 결과값 나옴.)
		System.out.println(replacedIp);
		
		
		// 13. 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		String id = " ";
		if(id.isEmpty()) {
			System.out.println("빈문자열");
		} else {
			System.out.println("빈문자열 아님");     //공백을 넣어도 빈문자열이 아님으로 나옴.
		}
		
		if(id.isBlank()) {
			System.out.println("빈문자열");
		} else {
			System.out.println("빈문자열 아님");     //공백은 제외.(since 11 이상 사용 가능)
		}
		
		if(id.trim().isEmpty()) {
			System.out.println("빈문자열");
		} else {
			System.out.println("빈문자열 아님");     //(since 8 환경에서 공백 제거)
		}
		
		
		
		// 연습. 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행 한다.
		String fullName = "apple.jpg";
		String fileName = "";  // apple
		String extName = "";   // jpg
		
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0, idxOfDot);
		extName = fullName.substring(idxOfDot + 1);
		System.out.println(fileName);
		System.out.println(extName);
		
		
		
		// 연습. 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 12345678890을 제외하고 한 글자씩 화면에 출력하시오.
		String str = "abc12345def67890ghijk";
		
		for(int i = 0; i <= str.length() - 1; i++) {          //마지막 인덱스 길이는 총 글자수-1임. 첫번째 글자 길이는 0
			System.out.println(str.charAt(i));
		}
		
		for(int i = 0; i <= str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') {	
				continue;
			}
			System.out.println(ch);				  //i에 길이를 입력하면 됨.(해당 방법을 주로 많이 사용)
		}

		
		

		
	
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
