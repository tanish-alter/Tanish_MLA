package com.test;

public class BookDetails {
	
	private int pages;
	
	private String publisher;
	
	private int year;
	
	private BookDetails bd;
	

	public BookDetails getBd() {
		return bd;
	}

	public void setBd(BookDetails bd) {
		this.bd = bd;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "BookDetails [pages=" + pages + ", publisher=" + publisher + ", year=" + year + ", bd=" + bd + "]";
	}
	
}
//Composition has a relationship