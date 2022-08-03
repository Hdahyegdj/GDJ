package ex07_override;

public class ExpressoMain {

	public static void main(String[] args) {
		
		Espresso espresso = new Espresso();
		espresso.taste();
		
		Americano americano = new Americano();
		americano.taste();
		
		CafeLatte cafeLatte = new CafeLatte();
		cafeLatte.taste();

	}

}
