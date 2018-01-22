package com.wong.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Description: Redis 列表
 * @Author: gang.wang
 * @Date: Created in 上午9:45 2018/1/17
 */
public class RedisListJava {

    public static void main(String[] args){
        Jedis jedis = RedisJava.connectRedis();

        //插入数据 lpush 从左边插入； rpush 从右边插入
        jedis.lpush("redisList","redis");
        jedis.lpush("redisList","mongodb");
        jedis.lpush("redisList","left1","left2");

        jedis.rpush("redisList","right1","right2");

        //查询所有元素
        List list = jedis.lrange("redisList",0,-1);
        list.stream().forEach(System.out::println);

        //从左边pop值, 取出值以后列表中不存在该值了
        String lvalue = jedis.lpop("redisList");
        System.out.println("left pop value :" + lvalue);

        //从右边pop值, 取出值以后列表中不存在该值了
        String rvalue = jedis.rpop("redisList");
        System.out.println("right pop value :" + rvalue);

        //查看类型
        String type = jedis.type("redisList");
        System.out.println("Type : " + type);

        //删除
        jedis.del("redisList");
    }
}
