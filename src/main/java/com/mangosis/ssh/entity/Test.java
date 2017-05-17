package com.mangosis.ssh.entity;

import com.google.code.ssm.api.CacheKeyMethod;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 2017/5/8.
 */

@Entity
@Table(name = "t_test",catalog = "ssh")
public class Test implements Serializable {

    private static final long serialVersionUID = -9049981895807105815L;

    private Long id;

    private String firstName;

    private String secondName;

    public Test() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @CacheKeyMethod
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name",length = 32)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "second_name",length = 32)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Test(Long id, String firstName, String secondName) {


        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
