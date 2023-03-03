package com.graphqljava.tutorial.bookDetails.aspect;

import com.graphqljava.tutorial.bookDetails.lib.MongoSortCriteriaCreator;
import com.graphqljava.tutorial.bookDetails.lib.SortExpression;
import com.graphqljava.tutorial.bookDetails.pojos.Pagination;
import com.intuit.graphql.filter.client.ExpressionFormat;
import com.intuit.graphql.filter.client.FilterExpression;
import graphql.schema.DataFetchingEnvironment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

/**
 * @author nevinsunny
 * date 01/03/23
 * time 1:19 PM
 */
@Aspect
@Component
public class GraphAspect {

//    @Before(value = "execution(* com.graphqljava.tutorial.bookDetails.BookController.*(..)) and args(dataFetchingEnvironment, pagination)")
//    @Before("@annotation(Nevin)")
//    @Around("execution(* *(.., @aspectjtest. (*), ..))")
//    public void beforeAdvice(JoinPoint joinPoint, String empId, String fname, String sname)
//    {
//
//        System.out.println("Before method:" + joinPoint.getSignature());
//
//        System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);
//    }

//    @Pointcut("execution(* com.graphqljava.tutorial.bookDetails.BookController.*(..))")
//    private void selectGetAge(){}
//
//    @Around("selectGetAge()")
//    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        System.out.println("Around advice");
//        Object[] args = proceedingJoinPoint.getArgs();
//
//
//        DataFetchingEnvironment dataFetchingEnvironment = (DataFetchingEnvironment) args[0];
//        Pagination pagination = (Pagination) args[1];
//
//        FilterExpression.FilterExpressionBuilder builder = FilterExpression.newFilterExpressionBuilder();
//        FilterExpression filterExpression = builder.args(dataFetchingEnvironment.getArguments())
//                .build();
//
//        SortExpression sortExpression =  SortExpression.build(dataFetchingEnvironment.getArguments());
//
//        Object[] args2 = new Object[3];
//
//        args2[0] = dataFetchingEnvironment;
//        args2[1] = sortExpression;
//        args2[2] = pagination;
//
//
//
//        Object result = proceedingJoinPoint.proceed(args2);
//        System.out.println("Returning " + result);
//        return result;
//    }
}
