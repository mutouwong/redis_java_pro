package com.wong.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description: Redis Hash表
 * @Author: gang.wang
 * @Date: Created in 下午2:03 2018/1/22
 */
public class RedisHashJava {


    public static void main(String[] args){

        Jedis jedis = RedisJava.connectRedis();

        //添加hash属性和值
        jedis.hset("hash","key1","value1");
        jedis.hset("hash","key2","value2");
        jedis.hset("hash","key3","value3");

        //获取hash值
        String value1 = jedis.hget("hash","key1");
        System.out.println("key1 values : " + value1);

        //获取全部key值
        Set<String> keys = jedis.hkeys("hash");
        keys.stream().forEach(System.out::println);

        //获取全部value值
        List<String> values = jedis.hvals("hash");
        values.stream().forEach(System.out::println);

        //删除某个值
        jedis.hdel("hash","key1");

        //获取所有值
        Map map = jedis.hgetAll("hash");
        System.out.println(map);

        //删除
        jedis.del("hash");

    }

}
