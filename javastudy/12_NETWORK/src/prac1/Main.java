
package prac1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		
		// C드라이브 storage에 XML 저장하기
		
		try {
			
			String apiURL = "https://kma.go.kr/XML/weather/sfc_web_map.xml" ;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection(); 	// 여기까지가 접속
			
			// 접속 확인
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("API 접속 실패");
				return;
			}
		
			// 바이트 입력 스트립 -> 문자 입력 스트림 -> 버퍼 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			File file = new File("C://storage", "sfc_web_map.xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// readLine() 메소드를 이용한 복사
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line + "\n");  
			}
 			
			// 닫기
			bw.close();
			br.close();
			con.disconnect();
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println(e.getMessage());   // 에러 메세지 표시
			System.out.println("API 서버 오류");			
		}
	}

}