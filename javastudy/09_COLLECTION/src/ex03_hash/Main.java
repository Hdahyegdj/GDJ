package ex03_hash;
import java.util.HashSet;
import java.util.Set;


// java의 hash는 해당 객체의 참조값으로 만듦.
// hash는 빠르게 확인하기 위해 사용. (hash -> equals 비교 순으로 진행)


public class Main {

	public static void main(String[] args) {
		/*
		 
		Book book1 = new Book();
		System.out.println(book1.hashCode());		// 653305407 - book1 객체의 참조값
		
		Book book2 = new Book();
		System.out.println(book2.hashCode());		// 1227229563 - book2 객체의 참조값
		
		System.out.println(book1, Eqauls(book2));
		*/
		
		Book book1 = new Book(1, "어린왕자");
		Book book2 = new Book(2, "홍길동전");
		Book book3 = new Book(3, "소나기");
		Book book4 = new Book(4, "소나기");
		
		System.out.println(book3.hashCode()); 	//49062722으로 book3과 4는 같은 hashcode가 나오므로 같은 객체라고 판단.
		System.out.println(book4.hashCode());
		
		Set<Book>books = new HashSet<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);	// 중복 저장 시도 -> "소나기"가 2번 나오므로 동일한 책이 나오지 못하도록 막아야함.(정상 동작하려면 Book 클래스에 hashCode(), equals() 메소드를 오버라이드 해야 함.)
		
		for(Book book : books) {
			System.out.println(book);
		}
		
	}

}
