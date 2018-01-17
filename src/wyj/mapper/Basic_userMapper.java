package wyj.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wyj.domain.Basic_user;
import wyj.domain.Inactive_user;

import java.util.List;

/**
 * Create by wdb on 2018/1/10 15:18
 */

public interface Basic_userMapper {

    //注册/登录时判断用户名是否已经存在
    @Select("select *from basic_user where user_name=#{user_name}")
    Basic_user selectByUser_name(@Param("user_name") String user_name);

    //注册时判断邮箱是否已经存在（已被注册）
    @Select("select *from basic_user where email=#{email}")
    Basic_user selectByEmail(@Param("email") String email);

    //未通过验证码激活的用户信息插入到临时数据库前检查是否已经存在
    @Select("select *from inactive_user where inactive_userEmail = #{inactive_userEmail}")
    Inactive_user selectInactiveUserInfo(@Param("inactive_userEmail") String inactive_userEmail);


    //未通过验证码激活时时插入的临时数据数据
    @Insert("insert into inactive_user(inactive_username,inactive_userEmail,code) values(#{inactive_username},#{inactive_userEmail},#{code})")
    int insertInactiveUserInfo(@Param("inactive_username") String inactive_username,
                       @Param("inactive_userEmail") String inactive_userEmail,
                        @Param("code") String code);
    //通过邮箱查找生成的code
    @Select("select code from inactive_user where inactive_userEmail = #{inactive_userEmail}")
    String selectCodeByEmail( @Param("inactive_userEmail") String inactive_userEmail);

    //定时删除临时数据库验证码，保证验证码时效性
    @Delete("delete from inactive_user where inactive_userEmail=#{inactive_userEmail}")
    int deleteInactiveUserInfo(@Param("inactive_userEmail") String inactive_userEmail);

    @Insert("insert into basic_user(user_name,password,email) values(#{user_name},#{password},#{email})")
    int insertUserInfo(@Param("user_name") String user_name,
                       @Param("password") String password,
                       @Param("email") String email);

    //登录：


}
