package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class LogTime {
	
	@Around("call(* mainApp.Conversation.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aspect called!");
		
		Object result = new Object();
		result = pjp.proceed();
		
		return result;
	}


}
