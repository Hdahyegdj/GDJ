package quiz01_library;

/*
 exam02 -> 09collection으로

Book[] books -> List<Book> books

Library.java
  addBook() - Full Chk 없어짐 
  removeBook() - Empty Chk 필요함(예외처리로 변경)
	removeBookByIndex() - 인덱스 정보를 이용해서 제거
	removeBookByObject() - 객체(Book) 정보를 이용해서 제거
  findBook() - Empty Chk 필요함(예외처리로 변경)
  printAllBooks() - Empty Chk 필요함(예외처리로 변경)
  * 추가
  modifyBook() - 책 제목을 입력 받아서 일치하는 책의 정보를 변경

 */

public class Book {
	
	private int bookNo;
	private String title;
	private String author;
	
	public Book() {
		
	}

	public Book(int bookNo, String title, String author) {		// 생성자
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}

	public int getbookNo() {		// get&set
		return bookNo;
	}

	public void setbookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override			//toString
	public String toString() {
		return "Book [bookNo=" + bookNo + ", title=" + title + ", author=" + author + "]";
	}

	
	@Override		//equals 추가 (객체끼리 비교할때 equals의 override가 필요)
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookNo != other.bookNo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
		
	
	
	

}
