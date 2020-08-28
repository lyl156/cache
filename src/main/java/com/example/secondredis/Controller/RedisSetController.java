package com.example.secondredis.Controller;

import com.example.secondredis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redisSet")
public class RedisSetController {
    private final RedisService redisService;

    RedisSetController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/testRedisSetAdd/{key}/{value}")
    public String tesSetAdd(@PathVariable String key, @PathVariable String value) {
        redisService.sAdd(key, value);
        return key + value;
    }
}
