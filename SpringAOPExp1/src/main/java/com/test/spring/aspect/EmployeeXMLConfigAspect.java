package com.test.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmployeeXMLConfigAspect {
	
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("EmployeeXMLConfigAspect :: Before invoking getName()");
		
		Object value = null;
		
		try
		{
			value = proceedingJoinPoint.proceed();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		System.out.println("EmployeeXMLConfigAspect :: After invoking getName() method return value "+value);
		
		return value;
	}
}
