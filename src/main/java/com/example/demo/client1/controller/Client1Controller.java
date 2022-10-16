package com.example.demo.client1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/write")
public class Client1Controller {
	@Autowired
	Environment env;
	@Autowired
	RestTemplate rs;
	
	@GetMapping("/show")
	public String show()
	{
		return "Inside-->Client1Controller"+env.getProperty("local.server.port");
	}
	@GetMapping("/receiveMsg")
	public String messageFromClient2()
	{
		String url="http://localhost:8081/get/sendMsg";
		String msgFrmClien2=rs.getForObject(url,String.class);
		return "messageFromClient1"+" and "+ msgFrmClien2;
	}
	@GetMapping("/receiveMsgH2")
	public String messageFromH2()
	{
		String url="http://localhost:8080/users/allusers";
		String data=rs.getForObject(url,String.class);
		return data;
	}

}
