package com.ojas;

@web
public class PrimeNumberServiceImpl {
	
	@WebMethod 
	public boolean isPrimeNumber(int number){
		for(int i=2;i<=number/2;i++){
			if(number % i ==0)
			return false;
			}
		return true;
	}
}
