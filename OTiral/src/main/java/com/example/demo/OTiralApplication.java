package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OTiralApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTiralApplication.class, args);

//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy EEEE");
//		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
//		String startOfMonth = format.format(cal.getTime());
//		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//		String endOfMonth =  format.format(cal.getTime());
//	
//		
//		
//		System.out.println(startOfMonth);
//		System.out.println(endOfMonth);

		LocalDate start = YearMonth.now().atDay(1);
		LocalDate end = YearMonth.now().atEndOfMonth();
//		System.out.println(start);
//		System.out.println(end);

		for (int i = start.getDayOfMonth(); i <= end.getDayOfMonth(); i++) {
			LocalDate dates = YearMonth.now().atDay(i);
			System.out.print(dates+"  ");

			DayOfWeek dayOfWeeks = dates.getDayOfWeek();
			System.out.print(dayOfWeeks +" ");
			
			System.out.println("Bla Bla..."+i);
		}
	}

}
