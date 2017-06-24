package com.netease.sellsystem.action;

import com.alibaba.fastjson.JSON;
import com.netease.sellsystem.bean.ContentBean;
import com.netease.sellsystem.dao.FinancialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaun on 2017/3/8 0008.
 */
@Controller
@RequestMapping("/financial")
public class FinancialAction {
    @Autowired
    private FinancialDao financialDaoImpl;

    @RequestMapping("/getBoughtList.do")
    public String getBoughtList( Model model, HttpSession session) {
       String username=(String) session.getAttribute("username");
        List boughtList =  null;
        try {
            boughtList=financialDaoImpl.getBoughtList(username);//list中每个元素为一个数组，包含5个元素
        }catch (Exception e){
            e.printStackTrace();
        }


        List<String> titleList=new ArrayList<String>();
        List<String> picList=new ArrayList<String>();
        List<String> timeList=new ArrayList<String>();
        List<Integer> priceList=new ArrayList<Integer>();
        List<Integer> quantityList=new ArrayList<Integer>();

        int total=0;
        for (int i = 0; i < boughtList.size(); i++) {
            Object[] orderInfo = (Object[]) boughtList.get(i);
            titleList.add(i,(String)orderInfo[0]);
            picList.add(i,(String)orderInfo[1]);
            timeList.add(i,(String)orderInfo[2]);
            int p=(Integer) orderInfo[3];
            int q=(Integer) orderInfo[4];
            priceList.add(i,p);
            quantityList.add(i,q);
            total+=p*q;
        }

        model.addAttribute("titleList", JSON.toJSONString(titleList));
        model.addAttribute("picList", JSON.toJSONString(picList));
        model.addAttribute("timeList", JSON.toJSONString(timeList));
        model.addAttribute("priceList", JSON.toJSONString(priceList));
        model.addAttribute("quantityList", JSON.toJSONString(quantityList));
        model.addAttribute("total", total);
        return "/view/hospitalmsg.jsp";
    }
}
