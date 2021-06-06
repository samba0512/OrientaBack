package com.samanecorp.orienta.entities;

import lombok.Data;

@Data
public class RegisterForm {
    private String username;
    private String password;
    private String repassword;

    public RegisterForm(String username, String password, String repassword) {
        this.username = username;
        this.password = password;
        this.repassword = repassword;
    }
}
