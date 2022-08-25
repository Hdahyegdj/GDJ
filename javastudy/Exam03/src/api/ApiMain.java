package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ApiMain {

	public static void main(String[] args) {
		String serviceKey = "w9zxrg1FuuzbmyI/klG6FCMugTu5beum0OgaTv3lWY3OAPps6aM9q10fTfq7UNnF/NZY8VNJ9S8uZJcsfBqz0w==";
		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("	http://apis.data.go.kr/B552061/AccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&type=json");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();	
		}
		
		String apiURL = urlBuilder.toString();
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}}

	public static String getResponse(String apiURL) {
		HttpURLConnection con = getConnection(apiURL);
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			}
		} catch(IOException e) {
			throw new RuntimeException("API 요청 오류", e);
		}
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
		
		try {
			URL url = new URL(apiURL);
			return (HttpURLConnection)url.openConnection();
		} catch(MalformedURLException e) {
			throw new RuntimeException("API 주소 오류", e);
		} catch(IOException e) {
			throw new RuntimeException("API 연결 오류", e);
		}
	}
	
	public static String readBody(InputStream in) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch(IOException e) {
			throw new RuntimeException("API 응답 오류", e);
		}
	}
	
	public static void createFile(String response) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("accident.txt"))) {
			bw.write(response);
			bw.flush();
		} catch(IOException e) {
			throw new RuntimeException("파일 생성 오류", e);
		}
	}
	
	
}
