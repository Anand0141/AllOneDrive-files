package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class Anand_LinkGen {

//	@RequestMapping("/linkgen/{name}")
//	public String linkGen(@PathVariable String name) throws UnknownHostException {
//
//		// this is system local address
//		InetAddress localhost = InetAddress.getLocalHost();
//
//		// this is our IP address
//		String ip = localhost.getHostAddress();
//
//		JSONObject obj = new JSONObject();
//		obj.put("message", "welcome " + name);
//
//		JSONObject obj2 = new JSONObject();
//
//		for (int i = 1; i < 4; i++) {
//			obj2.put("m" + i, "http://" + ip + "/api/linkgen/welcome/" + i);
//		}
//		obj.put("menu", obj2);
//		String json = obj.toString();
//
//		return json;
//	}

//	@GetMapping("/linkgen/welcome/{number}")
//	public Map<String, String> result(@PathVariable String number) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("result", number);
//		return map;
//
//	}

//	private String encode(int i) {
//		Random rand = new Random();
//		int rand_int1 = rand.nextInt(10000);
//		String s = String.valueOf(rand_int1);
//		int rand_int2 = rand.nextInt(10000);
//		String s1 = String.valueOf(rand_int2);
//		String res = s.concat("" + i);
//		String res1 = res.concat(s1);
//		return res1;
//	}
//
//	@GetMapping("/linkgen/welcome/{number}")
//	 public String result1(@PathVariable String number) {
//	 String res = number.substring(4,5);
//	return res;
//	}

}
