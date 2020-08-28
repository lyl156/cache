package com.example.secondredis.Controller;

import com.example.secondredis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redisHash")
public class RedisHashController {
    private final RedisService redisService;

    RedisHashController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/testRedisHashSet/{key}/{hashKey}/{value}")
    public String testHashSet(@PathVariable String key, @PathVariable String hashKey, @PathVariable String value) {
        redisService.hSet(key, hashKey, value);
        return key + hashKey + value;
    }
}
