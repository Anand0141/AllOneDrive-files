
/*
 * here we have to implement the all methods what are defined in Bookdao interface
 */
package com.ojas.spring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ojas.spring.mapper.BookMapper;
import com.ojas.spring.model.BookDetails;
@Component
public class BookDaoImpl implements BookDao {

	public JdbcTemplate template;
	@Autowired
	public BookDaoImpl(DataSource dataSource){
		template=new JdbcTemplate(dataSource);
		
	}
	@Override
	public List<BookDetails> getAllBooks() {
		//System.out.println("jkhkhkbh");
		return template.query("select * from bookdetails", new BookMapper());
	}

	@Override
	public BookDetails findBook(int bookId) {
		String getData="select * from bookdetails where bookid=?";
		return template.queryForObject(getData,new Object[] {bookId}, new BookMapper());
	}

	@Override
	public String deleteBook(int bookId) {
		
		return null;
	}
	
	public int[] batchUpdate(List<BookDetails> bookList){
		return template.batchUpdate("update bookdetails set bookName=? where bookid=?", 
				new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, bookList.get(i).getBookName());
						ps.setInt(2, bookList.get(i).getBookId());
						
					}
					
					@Override
					public int getBatchSize() {
						
						return bookList.size();
					}
				});
	}

	
	public int[] batchInsert(List<BookDetails> bookList){
		int[] insertBook= this.template.batchUpdate("insert into bookdetails(bookid,bookname,author,price) values(?,?,?,?)", 
				new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, bookList.get(i).getBookId());
						ps.setString(2, bookList.get(i).getBookName());
						ps.setString(3, bookList.get(i).getAuthor());
						ps.setInt(4, bookList.get(i).getPrice());
						
					}
					
					@Override
					public int getBatchSize() {
						
						return bookList.size();
					}
				});
		return insertBook;
	}

}
