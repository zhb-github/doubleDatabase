package com.jdbc.aop;

import com.jdbc.common.DataSourceTarget;
import com.jdbc.config.DataSourceName;
import com.jdbc.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;


/**
 * 多数据源，切面处理类 处理带有注解的方法类
 */
@Aspect
@Configuration
@Slf4j
public class DataSourceAspect {

    /**
     * 注意：这里的xxxx代表的是上面public @interface DataSource这个注解DataSource的包名
     */
    @Pointcut("@annotation(com.jdbc.common.DataSourceTarget)")
    public void dataSourcePointCut() {

    }

    @Around(value = "dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point)
        throws Throwable {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        DataSourceTarget ds = method.getAnnotation(DataSourceTarget.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceName.MASTER);
            log.debug("set datasource is " + DataSourceName.MASTER);
        } else {
            DynamicDataSource.setDataSource(ds.value());
            log.debug("set datasource is " + ds.value());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clear();
            log.debug("clean datasource");
        }
    }

}
