package com.lyq.model;

import java.io.Serializable;

/**
 * Created by 云强 on 2017/11/14.
 */
public class User  implements Serializable {
    private static final long serialVersionUId = 1L;

    private String id;
    private String name;

    public User(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
