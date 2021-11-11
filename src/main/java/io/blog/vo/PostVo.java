package io.blog.vo;

import lombok.Data;
import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;

@Data
public class PostVo {
    int ID;
    String TITLE;
    String CONTENTS;
    String IMAGE_URL;
    DATE CREATED_AT;
    DATE EDITED_AT;
    int VIEWS;
    int USER_ID;
}