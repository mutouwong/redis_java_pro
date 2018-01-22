package com.wong.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Description: Redis 集合操作
 * @Author: gang.wang
 * @Date: Created in 下午3:04 2018/1/22
 */
public class RedisSetJava {

    public static void main(String[] args){

        Jedis jedis = RedisJava.connectRedis();

        //添加值
        jedis.sadd("set","value1","value2","value3","value6");
        //添加值
        jedis.sadd("set1","value1","value4","value3","value5");

        //返回集合差集
        Set<String> diffSet = jedis.sdiff("set","set1");
        diffSet.stream().forEach(n -> System.out.println("set与set1差集为：" + n));

        //返回集合差集
        Set<String> diffSet2 = jedis.sdiff("set1","set");
        diffSet2.stream().forEach(n -> System.out.println("set1与set差集为：" + n));

        //取集合交集
        Set<String> sinterSet = jedis.sinter("set1","set");
        sinterSet.stream().forEach(n -> System.out.println("set1与set交集为：" + n));

        //取所有集合并集
        Set<String> unionSet = jedis.sunion("set1","set");
        unionSet.stream().forEach(n -> System.out.println("set1与set并集为：" + n));


        //删除值
        jedis.srem("set","value2");

        //查询所有元素
        Set<String> set = jedis.smembers("set");
        set.stream().forEach(System.out::println);

        //查询集合的成员数
        Long mems = jedis.scard("set");
        System.out.println("the set members count : " + mems);


        //查看类型
        String type = jedis.type("set");
        System.out.println("Type : " + type);

        //删除
        jedis.del("set");

        //有序集合
        jedis.zadd("zset",1,"value1");
        jedis.zadd("zset",2,"value2");
        jedis.zadd("zset",3,"value3");

        //获取指定范围的值
        Set<String> zset = jedis.zrange("zset",0,-1);
        zset.stream().forEach(System.out::println);

        //删除
        jedis.del("zset");


    }
}
