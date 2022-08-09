package ex07_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void printMovies(List<String> list ) {
		
		for(int i = 0, size = list.size(); i < size; i++) {		// 일반 for문
			System.out.print(list.get(i)); 	// 여기까지 영화 1편이 나옴.
			if(i < size - 1 ) {  	// size - 1 : 마지막 요소의 인덱스(마지막 요소에는 나오지 않도록 함)  // 마지막 인덱스는 언제나 "길이 -1"이다.
			System.out.print("->");		//"->"를 ","로 바꾸면 csv타입으로 변경됨.
			}			
		}	
		System.out.println(); 	// 줄바꿈용
	}
	
	public static void main(String[] args) {
		
		List<String> movies = new ArrayList<String>();
		movies.add("아바타");
		movies.add("쇼생크탈출");
		movies.add("명량");
		movies.add("에일리언");
		movies.add("여인의향기");
		
		printMovies(movies); 	// 아바타 -> 쇼생크탈출 -> 명량 -> 에일리언 -> 여인의향기

		// movies 리스트를 오름차순 정렬시킴
		Collections.sort(movies); 	//Collections는 java util
		printMovies(movies);
		
		// movies 리스트를 내림차순 정렬시킴
		Collections.reverse(movies);
		printMovies(movies);
		
		// 특정 요소의 인덱스 반환
		// 이진 검색(binary Search)을 이용하므로 검색 속도가 매우 빠름
		// 단. 크기순으로 정렬이 되어 있어야 한다.
		int idx = Collections.binarySearch(movies, "아바타");
		System.out.println(idx);

		
		
		
		
	}

}
