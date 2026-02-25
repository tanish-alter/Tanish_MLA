package com.test.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAfterAspect {
	
	@After("args(name)")
	public void logStringArguments(String name)
	{
		System.out.println("Running after advice String argument passed");
	}
	
	@AfterThrowing("within(com.test.model.Employee)")
	public void logException(JoinPoint joinPoint)
	{
		System.out.println("exception thrown in employee mthods "+joinPoint.toString());
	}
	
	@AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
	public void getNameReturningAdvice(String returnString)
	{
		System.out.println("getNameReturningAdvice executed Returning string "+returnString);
	}

}
