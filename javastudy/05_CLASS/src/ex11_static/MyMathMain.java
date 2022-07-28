package ex11_static;

public class MyMathMain {

	public static void main(String[] args) {
		
		MyMath math1 = new MyMath();
		System.out.println(math1.PI);
		System.out.println(MyMath.abs(-5));      
		
		System.out.println(MyMath.pow(2, 5));  // 2의 5제곱(32)

	}

}
