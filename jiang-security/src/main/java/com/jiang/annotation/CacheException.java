package com.jiang.annotation;

import java.lang.annotation.*;

/**
 * @ClassName CacheException
 * @Description: 自定义注解，有该注解的缓存方法会抛出异常
 * @Author jiang
 * @Date 2020/8/18 13:39
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
