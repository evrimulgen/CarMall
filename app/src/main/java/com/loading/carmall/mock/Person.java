package com.loading.carmall.mock;


import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.MultiItemEntity;

public class Person implements MultiItemEntity {
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String name;
    public int age;

    @Override
    public int getItemType() {
//        return GoodsParameterAdapter.TYPE_PERSON;
        return 111;
    }
}