package wyj.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyj.domain.Basic_user;
import wyj.domain.Inactive_user;
import wyj.mapper.Basic_userMapper;
import wyj.service.serviceImp.Basic_userServiceImp;
import wyj.util.Email;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by wdb on 2018/1/10 15:58
 */

@Controller
@RequestMapping("/basic_user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class Basic_userController {

    @Autowired
    @Qualifier("Basic_userService")
    Basic_userServiceImp basic_userServiceImp;

    //注册时验证用户名是否已经存在（存在为false、不存在为true）
    @RequestMapping("/selectByUser_name")
    @ResponseBody
    public boolean selectByUser_name(@Param("user_name")String user_name){

        boolean result=false;
        Basic_user basic_user =
                basic_userServiceImp.selectByUser_name(user_name);

        if (basic_user==null){
            result=true;
        }

        return  result;
    }

    //判断邮箱是否已经注册
    @RequestMapping("/selectByEmail")
    @ResponseBody
    public boolean selectByEmail(@Param("email")String email){

        boolean result=false;
        Basic_user basic_user=
                basic_userServiceImp.selectByEmail(email);
        if (basic_user==null){
            result=true;
        }
        return result;
    }

    //判断未激活用户是否入库，存在的话就先删除
    @RequestMapping("/selectInactiveUserInfo")
    @ResponseBody
    public boolean selectInactiveUserInfo(
            @Param("inactive_userEmail")  String inactive_userEmail){
        boolean result=false;

        System.out.println(inactive_userEmail);
        Inactive_user inactive_user =
                basic_userServiceImp.selectInactiveUserInfo( inactive_userEmail);

        System.out.println(inactive_user.getInactive_username());

        //存在为true
        if (inactive_user!=null){
            result=true;
        }
        return result;
    }
    //未验证用户插入到临时数据库（true表示插入成功，false表示失败）
    @RequestMapping("/insertInactiveUserInfo")
    @ResponseBody
    public boolean insertInactiveUserInfo(@Param("inactive_username") String inactive_username,
                                        @Param("inactive_userEmail")  String inactive_userEmail) throws MessagingException {

        boolean result=false;
        Random random=new Random();
        String code=random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10);
        int insertInactiveUserInfo =
                basic_userServiceImp.insertInactiveUserInfo(inactive_username, inactive_userEmail,code);
        if (insertInactiveUserInfo!=0){
            result=true;
        }
        Inactive_user inactive_user=new Inactive_user();
        inactive_user.setInactive_userEmail(inactive_userEmail);
        inactive_user.setCode(code);

        Email.t1(inactive_user);
        Timer timer = new Timer();
        //定时删除数据
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                basic_userServiceImp.deleteInactiveUserInfo(inactive_userEmail);
            }
        };
        timer.schedule(timerTask,180000);
        return result;
    }
    //查找验证码
    @RequestMapping("/selectCodeByEmail")
    @ResponseBody
    public int selectCodeByEmail(@Param("inactive_userEmail")  String inactive_userEmail,
                                    @Param("code") String code){
        int result=0;
        String selectCodeByEmail =
                basic_userServiceImp.selectCodeByEmail(inactive_userEmail);

        System.out.println(code);
        System.out.println(selectCodeByEmail);

        //验证码已经被删除失效
        if (selectCodeByEmail==null){
            result=1;
        //验证码有效但是输入错误
        }else if (selectCodeByEmail!=null&&!selectCodeByEmail.equals(code)){
            result=2;
        //验证码输入正确
        }else if (selectCodeByEmail!=null&&selectCodeByEmail.equals(code)){
            result=3;
        }
        return result;
    }

    //注册成功，插入数据到用户数据库
    @RequestMapping("insertUserInfo")
    @ResponseBody
   public boolean insertUserInfo(@Param("user_name") String user_name,
                                @Param("password")String password,
                                 @Param("email")String email){

        boolean result=false;

       int  insertUserInfo =
               basic_userServiceImp.insertUserInfo(user_name, password, email);

       //插入数据，注册成功
       if (insertUserInfo!=0){
           result=true;
       }

       return  result;
    }


    /**
     * 登录时的处理器
     */

    //登录时判断账户密码是否存在
    @RequestMapping("/checkLogin")
    @ResponseBody
    public int checkLogin(Basic_user basic_user, HttpServletResponse response
                          ){

        int i=0;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html:charset=utf-8");

        Basic_user basic_user1=
            basic_userServiceImp.selectByUser_name(basic_user.getUser_name());

        //用户不存在
        if (basic_user1==null){
            i=1;
            //密码不正确
        }else if (!basic_user1.getPassword().equals(basic_user.getPassword())){
            i=2;
            //用户存在，且密码正确
        }else {
            i=3;
        }

        return  i;
    }




}
