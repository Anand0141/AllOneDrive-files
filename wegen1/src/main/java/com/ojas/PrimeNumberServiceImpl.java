package com.ojas;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class PrimeNumberServiceImpl {
    
	@WebMethod
	public boolean isprimenumber(int n){
		
		for(int i=2;i<n/2;i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
		
	}
	
}
