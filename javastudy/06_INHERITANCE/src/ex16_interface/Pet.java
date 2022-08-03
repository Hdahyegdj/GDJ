package ex16_interface;

public class Pet {
	
	private String petName;

	public Pet(String petName) {		// 생성자 호출
		super();
		this.petName = petName;
	}

	
	public String getPetName() {		// get&setter
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	
	
	

}
