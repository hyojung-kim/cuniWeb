package com.example.demo.interceptor;

import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;

import groovy.ui.Console;
import lombok.extern.slf4j.Slf4j;

@Component("beforeActionInterceptor") // 컴포넌트 이름 설정
@Slf4j
public class BeforeActionInterceptor implements HandlerInterceptor {
	@Autowired
	MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestUri = request.getRequestURI();
		Map<String, Object> param = new HashMap<>();

		Enumeration<String> parameterNames = request.getParameterNames();

		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			Object paramValue = request.getParameter(paramName);

			param.put(paramName, paramValue);
		}

		ObjectMapper mapper = new ObjectMapper();
		String paramJson = mapper.writeValueAsString(param);
		
		String queryString = request.getQueryString();

		String requesturiQueryString = requestUri;
		if (queryString != null && queryString.length() > 0) {
			requesturiQueryString += "?" + queryString;
		}

		String urlEncodedRequesturiQueryString = URLEncoder.encode(requesturiQueryString, "UTF-8");

		request.setAttribute("requesturiQueryString", requesturiQueryString);
		request.setAttribute("urlEncodedRequesturiQueryString", urlEncodedRequesturiQueryString);
		request.setAttribute("param", param);
		request.setAttribute("paramJson", paramJson);

		
		HttpSession session = request.getSession();

		boolean isLogined = false;
		int loginedMemberId = 0;
		Member loginedMember = null;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			isLogined = true;
			loginedMember = memberService.getMemberById(loginedMemberId);
		}
		
	

		boolean isAjax = requestUri.endsWith("Ajax");
		request.setAttribute("isAjax", isAjax);
		
		
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMember", loginedMember);


		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
