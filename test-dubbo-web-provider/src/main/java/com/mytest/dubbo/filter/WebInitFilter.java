package com.mytest.dubbo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebInitFilter implements Filter {

	
	
	private Log log = LogFactory.getLog(this.getClass());

	private String encoding = "UTF-8";
	
	
	
	
	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		servletRequest.setCharacterEncoding(encoding);
		long timeBegin = System.currentTimeMillis();
		String  reqUrl = request.getRequestURL()+(request.getQueryString()==null?"":("?"+request.getQueryString()));
		String  reqIp = IpUtils.getIp(request);
		log.info("ip:"+reqIp+",访问url:"+reqUrl+",提交方式:"+request.getMethod());
		
		servletResponse.setCharacterEncoding(encoding);
		filterChain.doFilter(servletRequest, servletResponse);
		//filterChain.doFilter(servletRequest, servletResponse);
		log.info("ip:"+reqIp+",访问url:"+reqUrl+",提交方式:"+request.getMethod()+",use time:"+(System.currentTimeMillis()-timeBegin)+" ms");

		return;

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
