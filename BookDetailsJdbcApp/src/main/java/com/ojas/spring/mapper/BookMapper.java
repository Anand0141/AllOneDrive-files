package com.ojas.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ojas.spring.model.BookDetails;

public class BookMapper implements RowMapper<BookDetails> {

	@Override
	public BookDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		BookDetails bookDetails=new BookDetails();
		bookDetails.setBookId(resultSet.getInt("bookid"));
		bookDetails.setBookName(resultSet.getString("bookName"));
		bookDetails.setAuthor(resultSet.getString("author"));
		bookDetails.setPrice(resultSet.getInt("price"));
		return bookDetails;
	}

}
