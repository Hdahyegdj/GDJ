package quiz02_rsp;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		String[] rsp = {"가위", "바위", "보"};
		
		// rsp 배열에서 임의의 값을 선택하여 HashSet에 저장한다.
		// rsp[0] == "가위"
		// rsp[1] == "바위"
		// rsp[2] == "보"
		
		// 몇 번만에 HashSet에 모두 넣을 수 있는지 확인한다.
		
		Set<String> set = new HashSet<String>(); 
		int cnt = 0;
		
		while(set.size() < 3) { 		// 몇 번인지 모르니까 for문보다 while문을 사용하여 조건을 주는 것이 바람직함. (세트에 저장된 것이 3보다 작거나 3이 아니면 계속 진행)
			int i = (int)(Math.random() * 3); 	// 0,1,2 중 하나
			set.add(rsp[i]);
			cnt++;
		}

		System.out.println(set);
		System.out.println(cnt);
	}
}
