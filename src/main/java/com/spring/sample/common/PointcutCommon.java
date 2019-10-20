package com.spring.sample.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* com.spring.sample..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.sample..*Impl.get*(..))")
	public void getPointcut() {}
	
	
}
