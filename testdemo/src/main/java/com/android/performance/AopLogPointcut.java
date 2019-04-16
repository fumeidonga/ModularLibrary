package com.android.performance;

import com.android.modulcommons.utils.DVLogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 自定义Pointcuts
 * 首先，我们需要自定义一个注解类 AopLog
 * 然后，创建一个切入文件，内部通过一个Pointcut来指定在带有我们上面自定义注解类AopLog注解的所有方法上进行拦截
 * 最后，只需要在要进行切入的函数前加上@AopLog注解即可
 */
@Aspect
public class AopLogPointcut {

    /**
     * 在带有AopLog注解的方法进行切入（注:此处的 * *前面都要有一个空格）
     */
    @Pointcut("execution(@com.android.performance.AopLog * *(..))")
    public void logPointcut(){

    }

    @After("logPointcut")
    public void onLogPointcutAfter(JoinPoint joinPoint) {
        DVLogUtils.dt("onLogPointcutAfter");
    }

    @Before("logPointcut1")
    public void onLogPointcutBefore(JoinPoint joinPoint) {

    }

    @Around("logPointcut2")
    public void onLogPointcutAround(JoinPoint joinPoint) {

    }

}
