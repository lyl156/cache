//get and post : https://blog.toright.com/posts/1203/%E6%B7%BA%E8%AB%87-http-method%EF%BC%9A%E8%A1%A8%E5%96%AE%E4%B8%AD%E7%9A%84-get-%E8%88%87-post-%E6%9C%89%E4%BB%80%E9%BA%BC%E5%B7%AE%E5%88%A5%EF%BC%9F.html
package com.example.secondredis.Controller;

import java.util.concurrent.TimeUnit;

import com.example.secondredis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    private final StringRedisTemplate stringRedisTemplate;
    private final RedisService redisService;
    RedisController(StringRedisTemplate stringRedisTemplate, RedisService redisService) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisService = redisService;
    }

    @GetMapping("/testRedisString")
    public void testRedisString() {
        //System.out.println("hello");
//        stringRedisTemplate.opsForValue().set("test-string-value1", "Hello Redis");
        redisService.set("test-string-value1", "Hello Redis");
        System.out.println("successfully set");

    }
    @GetMapping("/testRedisStringTimeOut/{key}/{value}")
    public void testRedisStringTimeOut(@PathVariable String key, @PathVariable String value) {
//        stringRedisTemplate.opsForValue().set(key, value, 3, TimeUnit.HOURS);
        redisService.set(key, value, 3);
        System.out.println("successfully set");
    }
    @GetMapping(value="/testRedisStringGet/{key}")
    public String testRedisStringGet(@PathVariable String key) {
//        String value = stringRedisTemplate.opsForValue().get(key);
        Object value = redisService.get(key);
        return (String)value;
    }
    //add exception and http status
    @DeleteMapping(value="/testRedisStringDelete/{key}")  
    public String testRedisStringDelete(@PathVariable String key) {
        Object value = redisService.get(key);
//        String value = stringRedisTemplate.opsForValue().get(key);
        if (value == null) {
            return "no key";
        } else {
            stringRedisTemplate.delete(key);
            return "delete" + key;
        }
    }

    
}