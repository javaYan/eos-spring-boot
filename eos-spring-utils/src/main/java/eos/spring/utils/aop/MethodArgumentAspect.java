package eos.spring.utils.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by yanyuyu on 2017/3/1.
 */
@Aspect
@Component
@Order(1) //指定切面优先级  越大越优先
public class MethodArgumentAspect {
    @Pointcut("execution(* eos.spring.utils.aop.DemoAopService.*(..))")
    private void pointCutMethod() {
    }

    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        long startTime = System.nanoTime();
        try {
            Object proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            long endTime = System.nanoTime();
            Object[] args = joinPoint.getArgs();
            StringBuffer argsBuffer = new StringBuffer();
            if(args != null) {
                for(Object arg : args) {
                    argsBuffer.append(arg).append(",");
                }
                if(argsBuffer.length() > 0) {
                    argsBuffer.deleteCharAt(argsBuffer.length()-1);
                }
            }
            System.out.println(joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName() +" 方法参数: " + argsBuffer.toString());
        }
        return null;
    }

    @Before("pointCutMethod()")
    public void doBefore() {
        System.out.println("do before ..");
    }
}
