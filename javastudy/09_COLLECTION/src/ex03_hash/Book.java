package ex03_hash;

public class Book {
	
	private int bookNo;
	private String title;
	
	
	public Book(int bookNo, String title) {		// 생성자
		super();
		this.bookNo = bookNo;
		this.title = title;
	}


	@Override		// toString(정보 출력을 위해)
	public String toString() {
		return "Book [bookNo=" + bookNo + ", title=" + title + "]";
	}


	@Override		// Generate hashcode and equals (hash 이름을 가진 것들은 해당 소스를 대부분 넣어줘야함.)
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookNo;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
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
