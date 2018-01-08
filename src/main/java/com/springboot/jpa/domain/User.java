package com.springboot.jpa.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by renwujie on 2018/01/08 at 10:43
 */
@Entity
@NamedQuery(name = "User.findByName", query = "select name,age from User u where u.name=?1")
@Table(name = "testjdbc")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    public User() {
    }

    public User(Long id, String name, Integer age, String sex) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

}
