package com.qiu.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;


@Component
public class FallbackController implements ZuulFallbackProvider {

	
	
	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return "hystrix";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				// TODO headers 设定
				HttpHeaders headers = new HttpHeaders();
				MediaType mt =new MediaType("application","json",Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				// TODO 响应体
				return new ByteArrayInputStream("微服务不可用,请稍后在试。。".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				// TODO 状态文本 ok
				return this.getStatusCode().getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO fallback时的状态码
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// TODO 数字状态码 200
				return this.getStatusCode().value();
			}
			
			@Override
			public void close() {
				
				
			}
		};
	}

}
