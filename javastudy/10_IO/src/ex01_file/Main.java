package ex01_file;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void m1() {
		
		// File 클래스
		// 1. 패키지 : java.io
		// 2. 파일 및 디렉터리 관리
		// 3. 생성 방법
		// 		1) new File(경로, 파일)
		//		2) new File(파일)
		// 4. 윈도우의 경로 구분 방법 : 백슬래시(\)
		// 5. 리눅스의 경로 구분 방법 : 슬래시(/)
		
		// 폴더(디렉터리) 만들기
		File dir = new File("C:\\storage");	// import (java.io)	// storage 및에 연결된 객체 // 역슬래시 2개를 써야 1개로 인식함.(1개는 escape로 인식됨.)
		
		// 존재하지 않으면 만들겠다.
		if(dir.exists() == false) {		// if(!dir.exists())과 동일 // 존재(dir.exists())하지 않으면(false)
			dir.mkdirs();	// 다중폴더 일때 dirs, 개별폴더 dir
		}
		
		// 존재하면 삭제하겠다.
		else {
			// dir.delete(); 	// 지금 지운다.
			dir.deleteOnExit();  //JVM(자바버추얼머신)이 종료되면 지운다.
		}
	}
	
	
	public static void m2() {
		
		File file = new File("C:\\storage", "my.txt");
		
		try {
		if(file.exists() == false) {
			file.createNewFile(); // 파일 생성 시
		} else {
			file.delete();
		}
	    } catch(IOException e) {
	    	// 개발할 때 넣는 catch 블록 코드
	    	e.printStackTrace();  // 에러를 콘솔에 찍어라
	    } 
	}
	
	
	public static void m3() {
		
		File file = new File("C:\\storage", "my.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("경로 : " + file.getParent()); //getParent 자신의 속한 상위 폴더 가져옴.
		System.out.println("전체경로(경로 + 파일명) : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());	// 폴더인지 확인
		System.out.println("파일인가? " + file.isFile());
		
		long lastModifiedDate = file.lastModified();   // 마지막으로 수정된 날짜
		System.out.println("수정한 날짜 : " + lastModifiedDate);
		
		String lastModified = new SimpleDateFormat("a hh:mm yyyy-MM-dd").format(lastModifiedDate); // 오전 a // 객체 생성과 메소드 호출 함께 진행
		System.out.println("수정한 날짜 : " + lastModified);

		long size = file.length();  // 파일의 크기는 바이트 단위로 나옴.
		System.out.println("파일크기 : " + size + "byte");		// 영문 1글자 : 1바이트, 한글 1글자 : 2~3바이트(컴퓨터 환경에 따라 다름)
	}
	
	
	public static void m4() {
		
		File dir = new File("C:\\GDJ");
		
		File[] list = dir.listFiles();	// 디렉터리 내부의 모든 파일/디렉터리를 File 객체로 가져옴.
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());  // 들어가 있는 모든 파일/디텍터리 이름 확인 가능
		}
	}
	
	
	public static void m5() {
		
		// 플랫폼마다 다른 경로 구분자 지원
		File file = new File("C:" + File.separator + "storage" + File.separator + "my.txt");
		System.out.println(file.getName());
	}
	

	public static void q1() {
		
		File dir = new File("C:\\GDJ");
		File[] list = dir.listFiles();
		
		int dirCnt = 0;
		int fileCnt = 0;
		long totalSize = 0;
		for(File file : list) {		// 향상 for문
			if(file.isHidden()) {	// 숨긴 파일이면 다음 파일 가져옴
				continue;
			}
			String lastModified = new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(file.lastModified());
			String directory =  "" ;
			String size = "";
			if(file.isDirectory()) {
				directory = "<DIR>";
				size = "     ";
				dirCnt++;
			} else if(file.isFile()) {
				directory = "     ";
				size =  new DecimalFormat("#,##0").format(file.length()) + "";	//DecimalFormat("#,##0")는 숫자 1000단위 별로 ","입력
				fileCnt++;
				totalSize += Long.parseLong(size.replace(",", ""));		//,를 찾아서 빈 문자열로 변경하여 누적시켜줌 (replace는 해당 문자를 찾아 변경해줌)
			}
			String name = file.getName();
			System.out.println(lastModified + " " + directory + " " + size + " " + name);
		}
		
		System.out.println(dirCnt + "개 디렉터리");
		System.out.println(fileCnt + "개 파일" + new DecimalFormat("#,##0").format(totalSize) + "바이트");

	}
	
	
	public static void q2() {
		
		// C:\storage 디렉터리 삭제하기
		// 디렉터리가 비어 있어야 삭제할 수 있으므로 내부 파일을 먼저 삭제
		
		String sep = File.separator;
		
		File file = new File("C:" + sep + "storage", "my.txt");		// 내부 파일 삭제
		if(file.exists()) {
			file.delete();
		}
		
		
		File dir = new File("C:" + File.separator + "storage");		
		
		if(dir.exists()) {	// 있으면 지운다.
			dir.delete();
		}
	}
	

	public static void main(String[] args) {
		q1();

	}

}
