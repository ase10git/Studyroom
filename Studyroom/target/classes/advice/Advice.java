package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Advice {

	@Pointcut("execution(* *study.*Controller.*(..))")
	public void rolePoint() {};
	
	@Before("rolePoint()")
	public void before(JoinPoint joinPoint) {
		System.out.println("aop test");
	}
}
