package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



public class ApiSearchBook {

	public static void main(String[] args) {
		
		
		
		String clientId = "9V_oSUlVtIOVhdM9SqGT";
		String clientSecret = "JIV2NgAFiy";
		
		String query = null;
		String display = null;
		
		try {
							// Scanner sc / JOption.showInputDialog 사용
			
				Scanner sc = new Scanner(System.in);
				
				  System.out.print("검색 -> ");
			         String book = sc.next();
			         sc.nextLine();
			         sc.close();
			
							// 정상처리
				
			
			String apiURL = "http://openapi.naver.com/v1/search/book?query=" + URLEncoder.encode(book, "UTF-8");
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			BufferedReader br = null;
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();	 // sb에 모든 검색결과가 저장되어있음.
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString()); // json object로 변경(추가해야함) // buildpath잡기
			
			JSONArray items = obj.getJSONArray("items");
			
			File dir = new File("C:/download");		// (저장경로)
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir, book + ".html");	// dir. 검색어 + ".확장자"
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>검색결과</title>");
			out.println("</head>");
			out.println("<body>");
			
			for(int i = 0; i < items.length(); i++) {
	               JSONObject item = items.getJSONObject(i);
	               String title = item.getString("title");
	               String link = item.getString("link");
	               String image = item.getString("image");
	               out.println("<a href="+ link +">" + title + "<br>");
	               out.println("<img src=\""+ image + "\" width=\"100px\"><br>");
	               out.println("<hr>");
	            }
			
			out.println("</body>");
			out.println("</html>");
			out.close();
			
			System.out.println("성공");
			// sysout으로 성공/실패 유무 확인
			
			apiURL = URLEncoder.encode(apiURL, "UTF-8");
			
			
		} catch(Exception e) {
							// 인코딩 처리 URLEncoder.encode 사용
			
							// 예외처리
			
			
			e.printStackTrace();
		}
			
			try {
				
				File dir = new File("C:/download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, ".html");
				PrintWriter out = new PrintWriter(file);
				
				Date date = new Date();
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
	            System.out.println(simpleDateFormat.format(date));
				
	            out.println("예외메시지 " + e.getMessage());
	              out.println("예외시간 " + simpleDateFormat.format(date));
	            out.close();
	            
	            System.out.println("실패");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}	
	
}
