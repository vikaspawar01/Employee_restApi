package com.example.empApi.wrappers;

import org.springframework.stereotype.Component;

@Component
public class ResponseWrapper1 {
	String msg;
	Object data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
