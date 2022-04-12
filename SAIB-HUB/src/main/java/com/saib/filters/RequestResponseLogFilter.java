package com.saib.filters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
public class RequestResponseLogFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestResponseLogFilter.class);
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		ContentCachingRequestWrapper cachingRequestWrapper = new ContentCachingRequestWrapper(request);
		ContentCachingResponseWrapper cachingResponseWrapper = new ContentCachingResponseWrapper(response);
		filterChain.doFilter(cachingRequestWrapper, cachingResponseWrapper);
		
		String requestBody = getContent(cachingRequestWrapper.getContentAsByteArray(), cachingRequestWrapper.getCharacterEncoding());
		String responseBody = getContent(cachingResponseWrapper.getContentAsByteArray(), cachingResponseWrapper.getCharacterEncoding());

		
		logger.debug("Request URL :"+cachingRequestWrapper.getServerName()+":"+cachingRequestWrapper.getServerPort()+cachingRequestWrapper.getRequestURI());
		logger.debug("Request Body :"+requestBody);
		logger.debug("Response Body :"+responseBody);
		
		cachingResponseWrapper.copyBodyToResponse();
		
		
	}

	
	private String getContent(byte[] contentAsByteArray, String encoding) throws UnsupportedEncodingException 
	{
		return new String(contentAsByteArray, 0 , contentAsByteArray.length, encoding); 
	}
	
}
