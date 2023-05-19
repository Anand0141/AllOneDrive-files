package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Anand_Linkgen2 {

	private String number = "";

	@GetMapping("/welcome/{value}")
	public Map encode(@PathVariable int value) throws UnknownHostException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyy");
		String current_Date = now.format(format);
		System.out.println(current_Date);
		InetAddress localhost = InetAddress.getLocalHost();
		String ip = localhost.getHostAddress().trim();
		System.err.println(ip);
		char ch = current_Date.charAt(0);
		String result = "" + ch;
		int num = Integer.parseInt(result);
		for (int i = 1; i <= 10; i++) {
			number += num * i;
		}
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("message :", "Welcome User Linkgenv2 Demo");
		HashMap<Object, Object> encode = new HashMap<Object, Object>();
		for (int i = 1; i < 4; i++) {
			encode.put("e" + i, "http://" + ip + ":8055/api/linkgen2/encode/" + (value + i));
		}

		for (int i = 1; i < 4; i++) {
			encode.put("d" + i, "http://" + ip + ":8055/api/linkgen2/encode/" + "4l6l" + number.substring(0, 5)
					+ (value + i) + number.substring(5, 17));
		}

		map.put("menu", encode);
		return map;

	}

}
