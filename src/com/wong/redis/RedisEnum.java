package com.wong.redis;

/**
 * @Description: Rides 枚举类
 * @Author: gang.wang
 * @Date: Created in 上午9:37 2018/1/17
 */
public enum RedisEnum {

    REDIS_HOST("localhost"),
    ;

    private String name;

    private RedisEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
