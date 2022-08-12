package ex02_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter {
	
	public static void m1() {
		
		// JSON
		// 1. JavaScript Object Notation
		// 2. 자바스크립트 객체 표기법
		// 3. 객체 : {}
		// 4. 배열 : []
		
		// JSON-Java(JSON in Java) 라이브러리
		// 1. 객체 : JSONObject 클래스(Map 기반)
		// 2. 배열 : JSONArray 클래스(List 기반)
		
		JSONObject obj = new JSONObject();
		obj.put("name", "민경태");
		obj.put("age", 45);
		obj.put("man", true);
		obj.put("height", 180.5);
		System.out.println(obj.toString());   //obj.toString()  -> 텍스트로 변환
	}
	
	
	public static void m2() {
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "제임스");
		obj1.put("age", 30);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "에밀리");
		obj2.put("age", 40);
		
		
		JSONArray arr = new JSONArray();
		arr.put(obj1);
		arr.put(obj2);
		
		System.out.println(arr.toString());
	}
	
	public static void m3() {
		
		String str = "{\"name\":\"민경태\",\"man\":true,\"age\":45,\"height\":180.5}";
		
		JSONObject obj = new JSONObject(str);  // String source
		
		String name = obj.getString("name"); //object로 반환하는데 String으로 받아서 에러가 나기 때문에 (String)으로 casting 시켜줌
		boolean man = obj.getBoolean("man");
		int age = obj.getInt("age");
		Double height = obj.getDouble("height");
		
		System.out.println(name);
		System.out.println(man);
		System.out.println(age);
		System.out.println(height);
	}
	
	
	public static void m4() {
		
		String str = "[{\"name\":\"제임스\",\"age\":30},{\"name\":\"에밀리\",\"age\":40}]";
		
		JSONArray arr = new JSONArray(str); 	// 배열 사용 함으로 array 이용
		
		// 일반 for문 
		for(int i = 0, length = arr.length(); i < length; i++ ) {
			JSONObject obj = arr.getJSONObject(i);    // JSONObject는 상기 {\"name\":\"제임스\",\"age\":30}를 의미함. (현재 object는 2개)
			String name = obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + "," + age);
		}
		
		// 향상 for문 : get() 메소드로 동작. get() 메소드는 Object를 반환
		for(Object o : arr) {	  // JSONObject obj = arr 로 사용하면 err가 발생함으로 변경하여 사용
			JSONObject obj = (JSONObject)o;
			String name = obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + "," + age);
		}
	}
	

	public static void main(String[] args) {
	
		List<String> product1 = Arrays.asList("100", "새우깡", "1500");
		List<String> product2 = Arrays.asList("101", "양파링", "20000");
		List<String> product3 = Arrays.asList("102", "홈런볼", "3000");

		List<List<String>> list = Arrays.asList(product1, product2, product3);
		
		// list를 json String으로 만들어서 
		// C:\\storage\\product.json 파일에 write()
		
		
		JSONArray arr = new JSONArray(list);
		
		for(List<String> line : list)  { 	// 향상 for문
			JSONObject obj = new JSONObject();
			obj.put("number", line.get(0));
			obj.put("name", line.get(1));
			obj.put("price", line.get(2));
			arr.put(obj);
		}
		
		File file = new File("C:\\storage", "product.json");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(arr.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
