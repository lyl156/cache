package com.example.secondredis.Controller;

import com.example.secondredis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redisZSet")
public class RedisZSetController {
    private final RedisService redisService;

    RedisZSetController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/testRedisZSetAdd/{key}/{value}/{score}")
    public String tesSetAdd(@PathVariable String key, @PathVariable String value, @PathVariable Double score) {
        redisService.zsAdd(key, score, value);
        return key + value + score;
    }
}
