package com.example.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisController {

    private ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);

    private RedisTemplate< String, String > template = (RedisTemplate<String, String>) ctx.getBean("redisTemplate");

    public Object getValue( final String key ) {
        return template.opsForValue().get( key );
    }

    public void setValue( final String key, final String value ) {
        template.opsForValue().set( key, value );
        template.expire( key, 30, TimeUnit.SECONDS);
    }
}
