package quiz04_cart;

public class Product {
	
	private String name;
	private int price;  	// 모든 제품이 이름과 가격을 가짐.
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
	
	
	
	

}
