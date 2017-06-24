package com.netease.sellsystem.dao;

import com.netease.sellsystem.bean.CartBean;
import com.netease.sellsystem.bean.OrderBean;
import com.netease.sellsystem.bean.OrderDetailsBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
public interface CartDao {
    void buyContent(String cid, String cartId, int quantity);

    List getCart(String cartId);

    String purchase(String[] ids, String quantityList,String username);
}
