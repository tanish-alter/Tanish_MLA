package com.test;


import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the word:");
		
		String word = sc.nextLine();
		
		System.out.println("Enter 1st number:");
		
		int n1= sc.nextInt();
		
		System.out.println("Enter 2nd number:");
		int n2= sc.nextInt();
		
		System.out.println(word.substring(n1,n2));
		
		
	}
}
