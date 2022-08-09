package ex06_iteratot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	
	public static void m1() {
		
		// Iterator 인터페이스
		// 1. 특정 컬랙션(interface Collection)에 등록해서 사용
		// 2. 순회할 때 사용(for문 대응)
		// 3. 주요 메소드
		//  	1) hasNext() : 남아 있는 요소가 있으면 true 반환
		//		2) next() : 요소를 하나 반환	(갯수를 모르기 때문에 while문을 사용)
		// 4. 주로 Set에서 사용
		
		
		Set<String> set = new HashSet<String>();
		
		set.add("제육"); 	// set에 데이터 저장할때 쓰는 게 add 메소드
		set.add("닭갈비");
		set.add("돈까스");
		set.add("김찌치개");
		
		
		// Set를 조회할 반복자 itr
		Iterator<String> itr = set.iterator();	// java util 	// Set가 String이기 때문에 동일해야함.
		
		// hasNext() : 남아 있는 요소가 있으면
		// Next() : 그 요소를 꺼냄
				
		while(itr.hasNext()) {		// 주머니 속에서 무작위로 잡는 걸 hasNext()라고 하며 Next()가 잡은 걸 빼오는 거임.
			String element = itr.next();
			System.out.println(element);
		}
	}
	
	
	public static void m2() {
		
		// HashMap과 Iterator   // HashMap는 Iterator 직접 사용이 불가하며, 간접 사용이 가능하다.
		// 1. keySet() 메소드로 Key만 Set에 저장한다.
		// 2. key를 저장한 Set에 Iterator를 등록해서 사용한다.
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", 1);
		map.put("column", "제목");
		map.put("query", "날씨");
		
		
		Set<String> keys = map.keySet(); // 이렇게 하면 key값만 빠져나옴(영어)
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			Object value = map.get(key);
			System.out.println(key + ":" + value);
		}		
	}

	public static void main(String[] args) {
		m2();

	}

}
