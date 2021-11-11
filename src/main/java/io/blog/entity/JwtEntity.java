package io.blog.entity;

import lombok.Data;

@Data
public class JwtEntity {
    private String JwtSecretKey;
    public String token;
    public String data;
}
