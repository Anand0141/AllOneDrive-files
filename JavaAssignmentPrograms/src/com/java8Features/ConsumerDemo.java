package com.java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;



public class ConsumerDemo  {

//	@Override
//	public void accept(Integer t) {
//		System.err.println("printing "+t);
//		
//	}
//	
//	public static void main(String[] args) {
//		
//		ConsumerDemo c=new ConsumerDemo();
//		c.accept(122);
//		
//	}
	
	public static void main(String[] args) {
//		Consumer<Integer> con=(t)->System.out.println("printing "+t);
//		//con.accept(251);
//		
//		
//		List<Integer> l=Arrays.asList(1,2,3,4,5);
//		l.stream().forEach(con);
		
		
		Predicate<Integer> p=(t)->t%2==0;
		System.out.println(p.test(4));
		
		List<Integer> l=Arrays.asList(1,2,3,4,5);
		l.stream().filter(p).forEach(t->System.err.println(t));
		
		
		Supplier<String> st=()->"hi anand";
		System.out.println(st.get());
	}

	
}
