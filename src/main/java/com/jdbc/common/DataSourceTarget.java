package com.jdbc.common;

import java.lang.annotation.*;


/**
 * Created by 鸠摩智 on 2018/11/23.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceTarget {

    String value() default "";
}
