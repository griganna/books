package com.example.crudwithvaadin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String author;

	private Integer pageCount;

	protected Book() {
	}

	public Book(String name, String author, Integer pageCount) {
		this.name = name;
		this.author = author;
		this.pageCount = pageCount;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String firstName) {
		this.author = firstName;
	}

	@Override
	public String toString() {
		return String.format("Book[id=%d, name='%s', author='%s']", id,
				name, author);
	}

}
