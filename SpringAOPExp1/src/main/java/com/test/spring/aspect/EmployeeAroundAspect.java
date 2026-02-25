package com.test.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAroundAspect {
	
	@Around("execution(* com.test.model.Employee.getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("Before invoking getName() method");
		
		Object value = null;
		
		try
		{
			value = proceedingJoinPoint.proceed();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		System.out.println("after invoking getName() method return value");
		
		return value;
	}
}
