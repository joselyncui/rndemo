package com.vicky.demo.reactandroid;

import java.io.Serializable;

/**
 * Created by yao.cui on 2017/7/12.
 */

public class User implements Serializable {
    public String name;
    public String sex;

    public User(){}

    public User(String name,String sex){
        this.name = name;
        this.sex = sex;

    }

}
