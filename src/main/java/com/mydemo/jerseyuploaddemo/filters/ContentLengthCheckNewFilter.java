/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo.filters;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mydemo.jerseyuploaddemo.configure.ContentLengthChecked;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
@Provider
@Order(Ordered.LOWEST_PRECEDENCE)
@ContentLengthChecked
public class ContentLengthCheckNewFilter implements Filter {

	private static Logger LOG = LoggerFactory.getLogger(ContentLengthCheckNewFilter.class);

	// @Value("${settings.max.length}")
	private long MAX_LENGTH = 10000000L;



	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("---------------------------------");
	}



	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
		throws IOException, ServletException {
		int contentLength = servletRequest.getContentLength();
		if (contentLength > MAX_LENGTH) {
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			//response.setStatus(413);
			//response.getWriter().println("Datei zu groß");
			//response.getWriter().close();
			response.sendError(413);
			return;
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}



	@Override
	public void destroy() {

	}
}
