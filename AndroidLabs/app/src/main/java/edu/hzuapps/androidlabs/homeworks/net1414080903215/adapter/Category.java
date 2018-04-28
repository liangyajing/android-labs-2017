package edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter;

/**
 * Created by acer on 2018/4/25.
 */


public class Category {
    private String name;
    private int imageId;
    public Category(String name, int imageId) {
        super();
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageId;
    }
}
