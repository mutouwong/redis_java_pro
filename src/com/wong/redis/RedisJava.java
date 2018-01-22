package com.wong.redis;

import redis.clients.jedis.Jedis;

/**
 * @Description: java连接redis服务器
 * @Author: gang.wang
 * @Date: Created in 上午9:25 2018/1/17
 */
public class RedisJava {

    public static void main(String[] args){
        //connecting to redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server successfully");
        //check whether server is running or not
        System.out.println("Server is running:" + jedis.ping());
    }

    /**
     * 连接redis服务器
     */
    public static Jedis connectRedis() {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis(RedisEnum.REDIS_HOST.getName());
        System.out.println("Connection to server sucessfully");
        return jedis;
    }
}
