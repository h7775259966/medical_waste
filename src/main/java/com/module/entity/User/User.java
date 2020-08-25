package com.module.entity.User;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private Long id;
    private String username;
    private String birthday;
    private String sex;
    private String address;

}
