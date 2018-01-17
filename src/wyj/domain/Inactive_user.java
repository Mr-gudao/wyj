package wyj.domain;

/**
 * Create by wdb on 2018/1/10 21:44
 */

public class Inactive_user {

    private Integer inactive_userId;
    private String inactive_username;
    private String inactive_userEmail;
    private String code;

    public Inactive_user() {
    }

    public Inactive_user(Integer inactive_userId, String inactive_username, String inactive_userEmail, String code) {
        this.inactive_userId = inactive_userId;
        this.inactive_username = inactive_username;
        this.inactive_userEmail = inactive_userEmail;
        this.code = code;
    }

    public Integer getInactive_userId() {
        return inactive_userId;
    }

    public void setInactive_userId(Integer inactive_userId) {
        this.inactive_userId = inactive_userId;
    }

    public String getInactive_username() {
        return inactive_username;
    }

    public void setInactive_username(String inactive_username) {
        this.inactive_username = inactive_username;
    }

    public String getInactive_userEmail() {
        return inactive_userEmail;
    }

    public void setInactive_userEmail(String inactive_userEmail) {
        this.inactive_userEmail = inactive_userEmail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Inactive_user{" +
                "inactive_userId=" + inactive_userId +
                ", inactive_username='" + inactive_username + '\'' +
                ", inactive_userEmail='" + inactive_userEmail + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
