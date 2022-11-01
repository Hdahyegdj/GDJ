package com.gdu.app05.service;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.gdu.app05.domain.Movie;
import com.sun.net.ssl.HttpsURLConnection;

public interface MovieService {
	public List<Movie> getBoxOffice(String targetDt);
		// API요청 
	
		String serviceKey = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("http://www.kobis.or.kr/kobisopenapi/webservice/soap/boxoffice");
			urlBuilder.append("?key=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("targetDt=yyyymmdd");
			urlBuilder.append("itemPerPage");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();	
		}
		
		String apiURL = urlBuilder.toString();
		
		URL url = null;
		HttpsURLConnection con = null;
	
}
