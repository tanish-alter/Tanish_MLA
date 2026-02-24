package com.test;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements InitializingBean, DisposableBean {

	
	private Point pointA;
	
	private Point pointB;
	
	private Point pointC;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw() {
		System.out.println("Position A is : (" + pointA.getX()+ " , " + pointA.getY()+" )");
		System.out.println("Position B is : (" + pointB.getX()+ " , " + pointB.getY()+" )");
		System.out.println("Position C is : (" + pointC.getX()+ " , " + pointC.getY()+" )");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy method is called for Traingle.");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("InitializingBean init method is called for Triangle.");
		
	}
	
	public void customInit() {
		
		System.out.println("Custom init() called for Traingle.");
	}

	//if called custom init() method it has to be destroyed too.
	
	public void cleanUp() {
		System.out.println("Custom destroy() method called for Triangle.");
	}
}
