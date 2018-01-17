package wyj.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyj.domain.Basic_user;
import wyj.domain.Inactive_user;
import wyj.mapper.Basic_userMapper;
import wyj.service.Basic_userService;

import java.util.List;

/**
 * Create by wdb on 2018/1/10 15:48
 */

//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)

@Service("Basic_userService")
public class Basic_userServiceImp implements Basic_userService {


    @Autowired
    Basic_userMapper basic_userMapper;

    //注册时判断用户名是否存在 ..... 登录时判断用户是否已经注册
    @Override
    public Basic_user selectByUser_name(String user_name) {
        return basic_userMapper.selectByUser_name(user_name);
    }

    //注册时判断用户邮箱是否已被注册
    @Override
    public Basic_user selectByEmail(String email) {
        return basic_userMapper.selectByEmail(email);
    }

    //判断未激活用户是否入库，存在的话就先删除
    @Override
    public Inactive_user selectInactiveUserInfo( String inactive_userEmail) {
        return basic_userMapper.selectInactiveUserInfo(inactive_userEmail);
    }

    //未激活用户数据插入
    @Override
    public int insertInactiveUserInfo(String inactive_username, String inactive_userEmail,String code) {
        return basic_userMapper.insertInactiveUserInfo(inactive_username,inactive_userEmail,code);
    }

    @Override
    public String selectCodeByEmail(String inactive_userEmail) {
        return basic_userMapper.selectCodeByEmail(inactive_userEmail);
    }



    //定时删除临时数据库内容，保证验证码时效性
    @Override
    public int deleteInactiveUserInfo( String inactive_userEmail) {
        return basic_userMapper.deleteInactiveUserInfo(inactive_userEmail);
    }

    //注册时判断验证码是否正确且有效


    //注册成功时插入数据
    @Override
    public int insertUserInfo(String user_name, String password, String email) {
        return basic_userMapper.insertUserInfo(user_name,password,email);
    }
}
