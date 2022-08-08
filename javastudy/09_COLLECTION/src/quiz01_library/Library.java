package quiz01_library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;				// Scanner 자동완성으로 처리

public class Library {	
	
	private Scanner sc;
	private List<Book> books;				// 배열의 선언까지 완료(생성 X)
	//private int idx; (배열이 없어지면서 idx도 같이 사라짐.)					// 필드로 설정해야 모든 항목이 사용 가능함.
	
	public Library() {					// Main 상에 인수가 ()이므로 동일
		sc = new Scanner(System.in);
		books = new ArrayList<Book>();			// 100권으로 설정
	}
	
	private void addBook() {			// 외부처리를 막기 위해서는 public -> private로 변경.(err : 한번도 사용한 적이 없기 때문에 발생)
		//if(idx == books.length) {		// full chk 필요 없음.
		//	System.out.println("더 이상 등록할 수 없습니다.");
		//	return;	
		System.out.println("===책 등록===");
		System.out.print("책 번호 입력 >>> ");
		int bookNo = sc.nextInt();
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		Book book = new Book(bookNo, title, author); //new Book에서 ctrl+Space를 통해 입력 (@AllArgsConstructor를 나타냄)
		books.add(book);  							
	}
	
	private void removeBookByIndex() {
		// Book remove(int index) 메소드 이용
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다."); //RuntimeException은 unchked이므로 throw코드 생략 가능 // throw했을때는 Return 없이 끝남.
		}
		System.out.println("===책 삭제===");	
		System.out.print("삭제할 책의 번호 >>> ");
		int bookNo = sc.nextInt();	// 입력 받은 숫자가 1이면, idx 값이 0이 됨.
		for(int i = 0, length = books.size(); i < length; i++) {
			if(books.get(i).getbookNo() == bookNo) {
				Book removeBook = books.remove(i);
				System.out.println(removeBook + " 책을 삭제했습니다.");
				return;		// 삭제가 끝나면 바로 종료시켜야함.
			}
		}
		throw new RuntimeException("책 번호가 " + bookNo + "인 책이 없습니다.");
	}
	
	private void removeBookByObject() {
		// boolean remove(Object obj)
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("책 번호 입력 >>> ");
		int bookNo = sc.nextInt();
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		Book book = new Book(bookNo, title, author);
		if(books.remove(book)) {
			System.out.println(book);
		}
		throw new RuntimeException("책 번호가 " + bookNo + "인 책이 없습니다.");
	}
		
	
	private void findBook() {
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("===책 조회===");	
		System.out.print("조회할 책제목 입력 >>> ");
		String title = sc.next();
		for(int i = 0, length = books.size(); i < length; i++) {
			// 저장된 책 제목 : books[i].getTitle()
			// 조회할 책 제목 : title
			// String의 동등비교 : equals() 메소드
			if(books.get(i).getTitle().equals(title)) {		// if(title.equals(book[i].getTitle()) 동일하게 사용 가능
				System.out.println(books.get(i));
				return; 	// findBook() 메소드 종료		//break;를 입력하면 for이 종료되어 메소드가 바로 종료됨.	// else를 넣게 되면 모든책에 대해서 출력 됨.
			}
		}	// 책 목록에 없는 책을 입력했을 때 "찾는 책이 없습니다." 자리이기 때문에 상기에 for문이 종료하면 안됨.
		throw new RuntimeException("제목이 " + title + "인 책은 없습니다.");
	}
	
	
	private void printAllBooks() {
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("===전체조회===");
		for(Book book : books) {		// 향상 for문
			System.out.println(book);
		}
	}
	
	
	public void manage() {
		
		while(true) { 					// 무한루프
			
			try {			// while문 시작 시, try로 시작해야함.
			
			System.out.println("1.추가 2.삭제 3.조회 4.전체목록 0.프로그램종료 >>>");
			int choice = sc.nextInt();	// 입력 시, 상기 숫자 + enter key를 입력하므로 
			sc.nextLine();				// <- 추가하여 불피요한 enter를 없애줄때 사용
			switch(choice) {
			case 1 : addBook(); break;	// 15번의 코드를 실행하기 위해
			case 2 : removeBookByIndex(); break;
			case 3 : findBook(); break;
			case 4 : printAllBooks(); break;
			case 0 : System.out.println("Library 프로그램을 종료합니다. 감사합니다.");
					return; 	// manage() 메소드 종료
			default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");  // switch문에서 else대신 사용 // default 상의 break(switch문을 끝내주는 것)는 상관없음.
			}
			
		} catch (InputMismatchException e) {
			sc.next();
			System.out.println("명령은 정수입니다.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		}
	}
	
		
	
}
