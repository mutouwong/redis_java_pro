package com.wong.redis;

import redis.clients.jedis.Jedis;

/**
 * @Description: Redis Java 字符串示例
 * @Author: gang.wang
 * @Date: Created in 上午9:34 2018/1/17
 */
public class RedisStringJava {

    public static void main(String[] args){
        Jedis jedis = RedisJava.connectRedis();
        //set the data in redis string
        jedis.set("stringdata","Redis String Date");
        //get the stored data and print it
        String data = jedis.get("stringdata");
        System.out.println("Stored string in redis::" + data);

        //判断是否存在键值key
        boolean exists_flag = jedis.exists("stringdata");
        System.out.println("是否存在键值[stringdata]:"+ exists_flag);


        //删除某个键
        jedis.del("stringdata");

        //get the stored data and print it
        String data1 = jedis.get("stringdata");
        System.out.println("Stored string in redis::" + data1);

        //设置多个值
        jedis.mset("name","gang","age","13");
        System.out.println("name::" + jedis.get("name") + ";" + "age::" + jedis.get("key"));

        //判断key类型
        String type = jedis.type("name");
        System.out.println("类型为：" + type);


    }




}
