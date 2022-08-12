package ex03_reader;

public class Product {

	private String number;
	private String name;
	private int price;
	
	public Product() {  	// ctrl + space로 생성자 직접 생성하기
	}

	public Product(String number, String name, int price) {	   	 // 생성자
		super();
		this.number = number;
		this.name = name;
		this.price = price;
	}

	public String getNumber() {		  // get&setter
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override		// toString
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
}
