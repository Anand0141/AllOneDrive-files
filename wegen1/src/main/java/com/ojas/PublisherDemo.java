package com.ojas;

import javax.xml.ws.Endpoint;

public class PublisherDemo {

	public static void main(String[] args) {
		Endpoint point=Endpoint.publish("http://localhost:1137/ws/HelloWorld?wsdl",new PrimeNumberServiceImpl());
        System.out.println("your web services created : "+point.isPublished());

	}

}
