package wyj.domain;

/**
 * Create by wdb on 2018/1/9 22:22
 */

public class Basic_user {

    private Integer user_id;//用户ID
    private String user_name; //用户名
    private String password;//用户密码
    private String real_name;//真实姓名
    private String sex;  //性别
    private String phone;//电话
    private String id_card; //身份证
    private String address;//收货地址
    private Integer user_type;//用户类型
    private Integer delete_flag;  //删除标记
    private String email;//邮箱
    private String emailPw;//验证码
    private Integer prepare1;//备用1
    private String prepare2;//备用2
    private String prepare3;//备用3

    public Basic_user() {
    }

    public Basic_user(Integer user_id, String user_name, String password, String real_name, String sex, String phone, String id_card, String address, Integer user_type, Integer delete_flag, String email, String emailPw, Integer prepare1, String prepare2, String prepare3) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.real_name = real_name;
        this.sex = sex;
        this.phone = phone;
        this.id_card = id_card;
        this.address = address;
        this.user_type = user_type;
        this.delete_flag = delete_flag;
        this.email = email;
        this.emailPw = emailPw;
        this.prepare1 = prepare1;
        this.prepare2 = prepare2;
        this.prepare3 = prepare3;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailPw() {
        return emailPw;
    }

    public void setEmailPw(String emailPw) {
        this.emailPw = emailPw;
    }

    public Integer getPrepare1() {
        return prepare1;
    }

    public void setPrepare1(Integer prepare1) {
        this.prepare1 = prepare1;
    }

    public String getPrepare2() {
        return prepare2;
    }

    public void setPrepare2(String prepare2) {
        this.prepare2 = prepare2;
    }

    public String getPrepare3() {
        return prepare3;
    }

    public void setPrepare3(String prepare3) {
        this.prepare3 = prepare3;
    }

    @Override
    public String toString() {
        return "Basic_user{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", real_name='" + real_name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", id_card='" + id_card + '\'' +
                ", address='" + address + '\'' +
                ", user_type=" + user_type +
                ", delete_flag=" + delete_flag +
                ", email='" + email + '\'' +
                ", emailPw='" + emailPw + '\'' +
                ", prepare1=" + prepare1 +
                ", prepare2='" + prepare2 + '\'' +
                ", prepare3='" + prepare3 + '\'' +
                '}';
    }
}
