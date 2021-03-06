package io.blog.vo;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class PostVo {
    int ID;
    String TITLE;
    String CONTENTS;
    String CREATED_AT;
    String EDITED_AT;
    int VIEWS;
    int USER_ID;
}