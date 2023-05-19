
/*
 * model class
 * @author
 */
package com.ojas.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetails {

	private int bookId;
	private String bookName;
	private String author;
	private int price;
}
