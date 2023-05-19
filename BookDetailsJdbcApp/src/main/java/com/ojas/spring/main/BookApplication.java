package com.ojas.spring.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ojas.spring.configuration.SpringConfig;
import com.ojas.spring.dao.BookDao;
import com.ojas.spring.dao.BookDaoImpl;
import com.ojas.spring.model.BookDetails;

public class BookApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		BookDao dao = context.getBean(BookDaoImpl.class);

		System.out.println("************************************");
		System.out.println("The list of books are.....");
		List<BookDetails> list = dao.getAllBooks();
		list.stream().forEach(System.out::println);
		System.out.println("************************************");

		List<BookDetails> booklist = new ArrayList<>();
		BookDetails blist = new BookDetails();
		blist.setBookId(106);
		blist.setBookName("hibernate");
		blist.setAuthor("aaa");
		blist.setPrice(500);
		booklist.add(blist);
		
		
		BookDetails blist3 = new BookDetails();
		blist3.setBookId(107);
		blist3.setBookName("servlet");
		blist3.setAuthor("sss");
		blist3.setPrice(500);
		booklist.add(blist3);
		
		
		int[] insert = dao.batchInsert(booklist);
		System.out.println(Arrays.toString(insert));
		System.out.println("************************************");
		
		List<BookDetails> booklist1 = new ArrayList<>();
		BookDetails blist1 = new BookDetails();
		blist1.setBookName("java");
		blist1.setBookId(104);
		booklist1.add(blist1);
		
		BookDetails blist2 = new BookDetails();
		blist2.setBookName("spring");
		blist2.setBookId(105);
		booklist1.add(blist2);
		
		int[] update=dao.batchUpdate(booklist1);
		System.out.println(Arrays.toString(update));

	}

}
