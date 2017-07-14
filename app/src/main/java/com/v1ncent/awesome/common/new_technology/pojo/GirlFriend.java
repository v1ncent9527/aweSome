package com.v1ncent.awesome.common.new_technology.pojo;

/**
 * Created by v1ncent on 2017/7/10.
 */

public class GirlFriend {
    private String name;
    private String age;
    private String heiget;
    private String Constellation;

    public GirlFriend(String name, String age, String heiget, String constellation) {
        this.name = name;
        this.age = age;
        this.heiget = heiget;
        Constellation = constellation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeiget() {
        return heiget;
    }

    public void setHeiget(String heiget) {
        this.heiget = heiget;
    }

    public String getConstellation() {
        return Constellation;
    }

    public void setConstellation(String constellation) {
        Constellation = constellation;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "\n" +
                "年龄：" + age + "\n" +
                "身高：" + heiget + "\n" +
                "星座：" + Constellation;
    }
}
