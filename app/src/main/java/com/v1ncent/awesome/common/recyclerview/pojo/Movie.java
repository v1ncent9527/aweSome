package com.v1ncent.awesome.common.recyclerview.pojo;

/**
 * Created by v1ncent on 2017/7/4.
 */

public class Movie {
    public String name;
    public int length;
    public int price;
    public String content;

    public Movie(String name, int length, int price, String content) {
        this.name = name;
        this.length = length;
        this.price = price;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", price=" + price +
                ", content='" + content + '\'' +
                '}';
    }
}
