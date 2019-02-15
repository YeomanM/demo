package com.example.demo.aspect.resoler;

import com.example.demo.aspect.DataSource;
import com.example.demo.config.DataSourceContextHolder;
import com.example.demo.constants.DataSourceType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　  ┃
 * ┃　　　━　　  ┃
 * ┃　┳┛　┗┳  ┃
 * ┃　　　　　　  ┃
 * ┃　　　┻　　  ┃
 * ┃　　　　　    ┃
 * ┗━┓　　  ┏━┛
 * 　  ┃　　　┃神兽保佑
 * 　  ┃　　　┃代码无BUG！
 * 　  ┃　　　┗━━━┓
 * 　  ┃　　　　     ┣┓
 * 　  ┃　　　　　   ┏┛
 * 　  ┗┓┓┏━┓┓┏┛
 * 　    ┃┫┫　┃┫┫
 * 　    ┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2018/9/1
 */
@Component
@Aspect
public class DataSourceResoler {


    @Pointcut("@annotation(com.example.demo.aspect.DataSource)")
    public void pointcut(){ }

    @Before("pointcut()")
    public void changeDataSource(JoinPoint point){
        Class clazz = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] classes = ((MethodSignature) point.getSignature()).getParameterTypes();

        try {
            Method method = clazz.getMethod(methodName,classes);
            if (method.isAnnotationPresent(DataSource.class)){
                DataSource dataSource = method.getAnnotation(DataSource.class);
                DataSourceType dataSourceType = dataSource.value();
                DataSourceContextHolder.setDatasource(dataSourceType.getValue());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("pointcut()")
    public void clearDatasource(){
        DataSourceContextHolder.clearDatasource();
    }

}
