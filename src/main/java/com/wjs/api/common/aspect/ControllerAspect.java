package com.wjs.api.common.aspect;

import cn.com.common.base.rpc.RpcResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ControllerAspect {

    @Pointcut("execution(public * com.wjs.api.web..*.*(..))")
    public void doControllerPointcut() {
    }

    @Around("doControllerPointcut()")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            return new RpcResponse<>(throwable);
        }
    }

}
