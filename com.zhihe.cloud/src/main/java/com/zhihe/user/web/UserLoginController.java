package com.zhihe.user.web;

import com.zhihe.tool.util.Log;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserLoginController {
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping("/uac/auth/form")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        Log.i("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.?
        String exception = (String) request.getAttribute("shiroLoginFailure");
        Log.i("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                Log.i("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                Log.i("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                Log.i("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                Log.i("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        Log.i("------没有权限-------");
        return "403";
    }
}