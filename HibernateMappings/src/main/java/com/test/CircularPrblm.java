package com.test;

class A {//extends B{
	//A b = new A();
}

class B {//extends A{
	//B a = new B();
}

public class CircularPrblm {

	public static void main(String[] args) {
		
		System.out.println("main");
		
		B b = new B();
		
		System.out.println("After Object");

	}

}
