package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class LogTime {
	
	@Around("call(* mainApp.Conversation.*(..))")
	public Object exeTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object result = new Object();
		result = pjp.proceed();
		
		System.out.println();
		System.out.format("%d milliseconds have passed since the call of the method \"%s\"  and its end.", System.currentTimeMillis()-start, pjp.getSignature());
		System.out.println();
		return result;
	}


}
