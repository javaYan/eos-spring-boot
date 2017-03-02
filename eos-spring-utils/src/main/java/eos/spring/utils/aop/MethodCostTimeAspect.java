package eos.spring.utils.aop;

import org.aspectj.lang.JoinPoint;
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
@Order(2) //指定切面优先级  越大越优先
public class MethodCostTimeAspect {
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
            System.out.println(joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName() +" 方法耗时: " + (endTime-startTime)/1000 + " ms");
        }
        return null;
    }

    @Before("pointCutMethod()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName() + "开始执行...");
    }
}
