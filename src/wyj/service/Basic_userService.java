package wyj.service;

import wyj.domain.Basic_user;
import wyj.domain.Inactive_user;
import wyj.mapper.Basic_userMapper;

import java.util.List;

/**
 * Create by wdb on 2018/1/10 15:46
 */

public interface Basic_userService {

    Basic_user selectByUser_name(String user_name);

    Basic_user selectByEmail(String email);

    Inactive_user selectInactiveUserInfo( String inactive_userEmail);

    int insertInactiveUserInfo(String inactive_username,String inactive_userEmail,String code);

    String  selectCodeByEmail(String inactive_userEmail);

    int deleteInactiveUserInfo(String inactive_userEmail);

    int insertUserInfo(String user_name, String password, String email);

}
