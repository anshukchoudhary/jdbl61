package com.example.jbdl.demoredis;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
	
	
	// this method is only to create the connection using the pasowrd and public end point
	@Bean
	public LettuceConnectionFactory getFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("redis-16616.c274.us-east-1-3.ec2.cloud.redislabs.com", 16616);
		
		redisStandaloneConfiguration.setPassword("XIIN2VeDn7c7cfXTFHyo5qu6rJopWNCp");
		
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
		
		return lettuceConnectionFactory;
	}
	
	
	
	//What is serialzation - convert tge state of any object to byte stream 
	//if we want to transfer through netWoRk
	
	//FOR REDIS TO JAVA WE SHOULD DESERIALZE 
	
	
	@Bean 
	public RedisTemplate<String, Object> getTemplate(){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		
		redisTemplate.setConnectionFactory(getFactory());
		redisTemplate.afterPropertiesSet();
		
		
		
		return redisTemplate;
		
		
	}
	
	
	
	
	
	
	

 

}
