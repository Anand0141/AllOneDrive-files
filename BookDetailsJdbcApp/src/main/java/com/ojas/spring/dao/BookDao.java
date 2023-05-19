package com.ojas.spring.dao;

import java.util.List;

import com.ojas.spring.model.BookDetails;

public interface BookDao {

	public List<BookDetails> getAllBooks();

	public BookDetails findBook(int bookId);

	public String deleteBook(int bookId);

	public int[] batchUpdate(List<BookDetails> bookList);

	public int[] batchInsert(List<BookDetails> bookList);
}
