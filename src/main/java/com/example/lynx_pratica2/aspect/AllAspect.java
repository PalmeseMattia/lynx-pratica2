package com.example.lynx_pratica2.aspect;

import com.example.lynx_pratica2.entity.Book;
import com.example.lynx_pratica2.entity.BookOrder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AllAspect {

    @Pointcut("execution(* com.example.lynx_pratica2.controller.*.*(..))")
    private void forControllerPackage(){};

    @Before("forControllerPackage()")
    public void before(JoinPoint joinPoint){

        String method=joinPoint.getSignature().toShortString();

        log.info("before "+method);

        Object[] args= joinPoint.getArgs();

        for (Object arg:
             args) {
            log.info("argument: "+arg);
        }
    }

    @AfterReturning(pointcut="forControllerPackage()",
            returning="res"
    )
    public void afterReturning(JoinPoint joinPoint, Object res) {

        String method=joinPoint.getSignature().toShortString();

        log.info("after returning: "+method);

        log.info("res: "+res);
    }

/*    @Around("forControllerPackage()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        String method=point.getSignature().toShortString();

        log.info("around: "+method);


        Object res=null;

        try {
            res=point.proceed();
            if (res == null) {
                throw new RuntimeException("problem with request");
            }
            if (res instanceof BookOrder) {
                BookOrder bookOrder= ((BookOrder) res);
                if (bookOrder.getBook() == null) {
                    throw new RuntimeException("problem with book in order");
                }
            }
            if (res instanceof Book) {
                Book book= ((Book) res);
                if (book.getStock() < 0) {
                    throw new RuntimeException("The stock is always higher or equal than 0");
                }
            }

            return res;
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return null;

    }*/

    @After("forControllerPackage()")
    public void after(JoinPoint joinPoint) {

        String method=joinPoint.getSignature().toShortString();
        log.info("after: "+method);
        log.info("finish");
        log.warn("============================================================================");

    }

    @AfterThrowing(
            pointcut="forControllerPackage()",
            throwing="exc"
    )
    public void afterThrowing(JoinPoint joinPoint
            ,Throwable exc) {

        String method=joinPoint.getSignature().toShortString();
        log.info("after throwing: "+method);

        log.error("exc: "+exc.getMessage());
    }


}
