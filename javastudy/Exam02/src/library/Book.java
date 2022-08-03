package library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor 		// new Book()
@AllArgsConstructor		// new Book(1, "어린왕자", "생텍쥐베리")		// -<이렇게 생성하고 싶으면 앞에 @All..를 넣어주면 됨.
@Getter					// getBookNo(), getTitle(), getAuthor()
@Setter					// setBookNo(), setTitle("어린왕자"), setAuthor("생택쥐베리")
@ToString				// String toString() {...}   // -> system.out.println(books[i]);에서 사용하기 위해 추가
public class Book {	
	private int bookNo;		// 1~100권까지 자동 부여
	private String title;	// 사용자 입력
	private String author;	// 사용자 입력

}
