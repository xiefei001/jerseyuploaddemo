/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
public class Service {

	@Value("${message:World}")
	private String msg;



	public String message() {
		return this.msg;
	}
}
