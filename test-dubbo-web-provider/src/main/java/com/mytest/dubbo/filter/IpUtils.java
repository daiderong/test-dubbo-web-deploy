package com.mytest.dubbo.filter;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;


public class IpUtils {
	
	/**
	 * 获得客户端Ip.
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(final HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-client-ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		
		// 多级反向代理
		if (null != ip && !"".equals(ip.trim())) {
			StringTokenizer st = new StringTokenizer(ip, ",");
			if (st.countTokens() > 1) {
				return st.nextToken();
			}
		}
		return ip;
	}
	
	
	public static boolean isLocalIp(String ip){
		if(ip.startsWith("10.")|| ip.startsWith("172.16.")|| ip.startsWith("172.31.")||ip.startsWith("192.168.")||
				ip.startsWith("127.0") ||ip.startsWith("0:0:0") ) 
				
				{
			return true;
		}
		return false;
	}

	
	
}

