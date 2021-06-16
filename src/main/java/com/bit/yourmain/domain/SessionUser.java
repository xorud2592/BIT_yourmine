package com.bit.yourmain.domain;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private Long no;
    private String name;
    private String id;
    private String phone;
    private String address;
    private Role role;


    public SessionUser(Users users) {
        this.no = users.getNo();
        this.name = users.getName();
        this.id = users.getId();
        this.phone = users.getPhone();
        this.address = users.getAddress();
        this.role = users.getRole();
    }
}
