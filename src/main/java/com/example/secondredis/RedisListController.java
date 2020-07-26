package com.example.secondredis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/core/RedisTemplate.html#opsForList--
//@SuppressWarnings("rawtypes")
@RestController
@RequestMapping(value = "/redisList")
public class RedisListController {
    private final RedisTemplate redisTemplate;

    RedisListController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/testRedisListLeftPush/{key}/{value}")
    public String testLeftPush(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForList().leftPush(key, value);
        return key + value;
    }

    @GetMapping("/testRedisListRightPush/{key}/{value}")
    public String testRighttPush(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForList().rightPush(key, value);
        return key + value;
    }

    @GetMapping("/testRedisListLeftPop/{key}")
    public void testLeftPop(@PathVariable String key) {
        Object leftFirstElement = redisTemplate.opsForList().leftPop(key);
        System.out.println(leftFirstElement);
    }
}