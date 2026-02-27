package com.test.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspectJoinPoint {
	
	@Before("execution(public void com.test.model..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint)
	{
		System.out.println("before executing loggingAdvice on method : "+joinPoint.toString());
		
		System.out.println("arguments passed : "+Arrays.toString(joinPoint.getArgs()));
	}
	
	@Before("args(name)")
	public void logStringArguments(String name)
	{
		System.out.println("String argument passed : "+name);
	}
}
