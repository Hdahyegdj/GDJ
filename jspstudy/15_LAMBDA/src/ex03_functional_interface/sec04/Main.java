package ex03_functional_interface.sec04;

public class Main {

	public static void main(String[] args) {


		Calculator calc = (a, b) -> a + b;
		System.out.println(calc.add(1, 1));		// a와 b가 각각 1이 됨.(결과 2)
		
	}

}
// 14장 lambda 변경