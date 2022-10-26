package service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NaverCaptchaService {		// service 하나당 3개 method 
	public String getCaptchaKey();
	public Map<String, String> getCaptchaImage(HttpServletRequest request, String key);
	public void refreshCaptcha(HttpServletRequest request, HttpServletResponse response);
	public boolean validateUserInput(HttpServletRequest request);
}

