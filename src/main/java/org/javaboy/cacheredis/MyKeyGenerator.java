package org.javaboy.cacheredis;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 缓存key生成器
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/15 11:22
 */
@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName()+"::"+ Arrays.toString(params);
    }
}
