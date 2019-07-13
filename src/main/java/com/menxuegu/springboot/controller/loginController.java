package com.menxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {
    @PostMapping("/login")
    public String login(HttpSession   session,String username, String password, Map< String,Object> map) {
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "main/login";
        }
    }

    /**
     * 退出登入
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        //1.清空session 中的用户信息
        session.removeAttribute("loginUser");
        //注销session
        session.invalidate();
        //返回登入页面
        return "redirect:/index.html";
    }

}
