package com.netease.sellsystem.action;

import com.netease.sellsystem.dao.BuyerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Shaun on 2017/3/7.
 */
@Controller
@RequestMapping("/user")
public class LoginAction {
    @Autowired
    private BuyerDao buyerDaoImpl;

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request, HttpSession session) {
        if (buyerDaoImpl.isExit(username, password)) {
            List userList = buyerDaoImpl.getUserInfo(username, password);
            Object[] userInfo = (Object[]) userList.get(0);
            session.setAttribute("name", userInfo[0]);
            session.setAttribute("cartId", userInfo[1]);
            session.setAttribute("userType", userInfo[2] + "");
            session.setAttribute("username", userInfo[3]);

            return "redirect:/content/getContentList.do?page=1&type=" + userInfo[2];
        } else {
            request.setAttribute("err_msg", "用户名或密码错误");
            return "/view/login.jsp";
        }
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("name");
        session.removeAttribute("cartId");
        session.removeAttribute("userType");
        session.removeAttribute("username");

        return "/view/login.jsp";
    }
}
