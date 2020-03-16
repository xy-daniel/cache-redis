package org.javaboy.cacheredis;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/15 10:53
 */
@Service
//缓存的配置除了在下面的每一个方法上面进行配置当然也可以同意在这个类上进行配置四种东西cacheName,KeyGenerator,cacheManager,cacheResolver
@CacheConfig(cacheNames = "c1", keyGenerator = "myKeyGenerator")
public class UserService {

    //方法开启缓存---->默认情况方法的参数就是缓存的key,方法的返回值就是缓存的value---->get "c1::1"/"c1::2"---->get "c1::SimpleKey [1,name]"/"c1::SimpleKey [1,name1]"(只有参数一样的时候才会调用缓存)
    //cacheNames指定使用哪一个缓存
    //key在多参数的情况下指定哪一个参数才是我们缓存到redis中的key---->可以使用#method/methodName/caches/args/target(当前被调用的对象)\targetClass(当前被调用对象的class)---->当然我们可以自定义key生成器
    //keyGenerator---->自定义key生成策略---->keyGenerator = "myKeyGenerator"
    @Cacheable(cacheNames = "c1")
    public User getUserById(Integer id) {
        System.out.println("getUserById>>>>id:" + id);
        return new User(1, "name", "author");
    }

    //删除
    @CacheEvict(cacheNames = "c1")
    public void deleteUserById(Integer id){
        System.out.println("deleteUserById>>>>"+id);
    }

    //更新
     @CachePut(cacheNames = "c1")
    public User updateUserById(Integer id){
        System.out.println("updateUserById>>>>id:" + id);
        return new User(1, "name_update", "author_update");
    }
}
