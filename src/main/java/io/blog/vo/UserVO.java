package io.blog.vo;

public class UserVO {
    int ID;
    String USERNAME;
    String NICKNAME;
    String EMAIL;
    String PASSWORD;

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
    }

    public void setEmail(String email) {
        this.EMAIL = email;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getNICKNAME() {
        return NICKNAME;
    }

    public String getEmail() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
