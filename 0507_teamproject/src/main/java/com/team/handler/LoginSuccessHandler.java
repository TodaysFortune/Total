package com.team.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.team.teamproject.ITBoardController;

@Component("LoginSuccessHandler")
class LoginSuccessHandler implements AuthenticationSuccessHandler{

	private final RequestCache requestCache = new HttpSessionRequestCache();
    private final RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
	private final String defaultUrl="/";
	private static final Logger LOG = LoggerFactory.getLogger(ITBoardController.class);
	
	@Override	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		registerIdCookie(response,authentication);
		resultRedirectStrategy(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	private void registerIdCookie(HttpServletResponse response,Authentication authentication) {
		LOG.debug("registerIdCookie");
		Cookie cookie=new Cookie("Cookie_userID",authentication.getName());//쿠키를 만들어서 , id를 등록하고 내보낸다
		response.addCookie(cookie);
	}

	private void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException{
			SavedRequest savedRequest = requestCache.getRequest(request, response);
	        if(savedRequest!=null && savedRequest.getMethod().equals("GET")) { // 
	            String targetUrl = savedRequest.getRedirectUrl();
	            redirectStratgy.sendRedirect(request, response, targetUrl);
	        } else {
	            redirectStratgy.sendRedirect(request, response, defaultUrl);
	        }
	        
	}
	
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null) return;
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }


	
}
