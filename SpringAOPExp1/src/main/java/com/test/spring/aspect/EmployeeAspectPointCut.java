package com.test.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointCut {
	
	@Before("getNamePointcut()")
	public void loggingAdvice()
	{
		System.out.println("execution logging advice on getName()");
	}
	
	@Before("getNamePointcut()")
	public void secondAdvice()
	{
		System.out.println("executing secondAdvice on getName()");
	}
	
	@Pointcut("execution(public String getName())")
	public void getNamePointcut()
	{
		
	}
	
	@Before("allMehtodsPointcut()")
	public void allServiceMethodsAdvice()
	{
		System.out.println("Before executing service mthod");
	}
	
	@Pointcut("within(com.test.service.*)")
	public void allMehtodsPointcut()
	{
		
	}

}
