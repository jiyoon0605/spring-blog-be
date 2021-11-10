package io.blog.vo;

import lombok.Data;

@Data
public class JwtVo {
    private String JwtSecretKey;
    public String token;
    public String data;
}
