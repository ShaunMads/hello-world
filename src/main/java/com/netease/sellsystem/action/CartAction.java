package com.netease.sellsystem.action;

import com.alibaba.fastjson.JSON;
import com.netease.sellsystem.bean.ContentBean;
import com.netease.sellsystem.dao.CartDao;
import com.netease.sellsystem.dao.ContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shaun on 2017/3/8 0008.
 */
@Controller
@RequestMapping("/cart")
public class CartAction {
    @Autowired
    private CartDao cartDaoImpl;
    @Autowired
    private ContentDao contentDaoImpl;

    @RequestMapping("/buyContent.do")
    public String buyContent(String goodsID, int num, HttpSession session) {
        String cartId = (String) session.getAttribute("cartId");
        try {
            cartDaoImpl.buyContent(goodsID, cartId, num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/content/getContentList.do?page=1&type=1";
    }

    //购物车：订单
    @RequestMapping("/getCart.do")
    public String getCart(HttpSession session, Model model) {
        String cartId = (String) session.getAttribute("cartId");
        List<ContentBean> cartContent = new ArrayList<ContentBean>();
        List<Integer> quantityList = new ArrayList<Integer>();
        int total = 0;
        try {
            List cartDetails = cartDaoImpl.getCart(cartId);
            Map<String, Integer> map = new HashMap<String, Integer>();

            for (int i = 0; i < cartDetails.size(); i++) {
                Object[] contentInfo = (Object[]) cartDetails.get(i);
                map.put((String) contentInfo[0], (Integer) contentInfo[1]);
            }

            for (String content : map.keySet()) {
                ContentBean contentBean = contentDaoImpl.getContentById(content);
                int quantity = map.get(content);
                total += contentBean.getPrice() * quantity;
                cartContent.add(contentBean);
                quantityList.add(quantity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("cartContent", JSON.toJSONString(cartContent));
        model.addAttribute("quantityList", JSON.toJSONString(quantityList));
        model.addAttribute("total", total);
        return "/view/metionsctrl.jsp";
    }

    //购买功能:1.生成订单和订单详情2.生成新购物车3.修改订单购买数量
    //cartContent经过了JSOn处理
    @RequestMapping("/purchase.do")
    public String purchase(String cartContent,String quantityList, HttpSession session) {
        String username = (String) session.getAttribute("username");
        //System.out.print(cartContent);
        String[] ids = cartContent.split(" ");

        String cartId = "";
        try {
            cartId=cartDaoImpl.purchase(ids, quantityList, username);
        }catch (Exception e){
            e.printStackTrace();
        }

        session.removeAttribute("cartId");
        session.setAttribute("cartId", cartId);
        return "/cart/getCart.do";
    }

}
