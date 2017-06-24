package com.netease.sellsystem.dao.impl;

import com.alibaba.fastjson.JSONArray;
import com.netease.sellsystem.bean.*;
import com.netease.sellsystem.dao.CartDao;
import com.netease.sellsystem.utils.MD5Code;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Shaun on 2017/3/8 0008.
 */
@Component
@Transactional
public class CartDaoImpl implements CartDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    //1.创建CartDetailsBean，2.设置content的销售数量 3.设置cart总价
    //并没有实现事务
    public void buyContent(String cid, String cartId, int quantity) {
        Session session = getSession();
        String sql = "UPDATE  content SET sale_quantity=sale_quantity+:sale_quantity WHERE content_id=:content_id";
        session
                .createSQLQuery(sql)
                .setParameter("sale_quantity", quantity)
                .setParameter("content_id", cid)
                .executeUpdate();

        CartDetailsBean cartDetailsBean = new CartDetailsBean();
        cartDetailsBean.setCartId(cartId);
        cartDetailsBean.setCdetailsId(MD5Code.getMD5("CartId" + System.currentTimeMillis()));
        cartDetailsBean.setContentId(cid);
        cartDetailsBean.setQuantity(quantity);

        session.save(cartDetailsBean);

        sql = "SELECT price FROM content WHERE content_id=:content_id";
        Integer price = (Integer) session
                .createSQLQuery(sql)
                .setParameter("content_id", cid)
                .uniqueResult();

        sql = "UPDATE  cart SET total=total+:total WHERE cart_id=:cart_id";
        session
                .createSQLQuery(sql)
                .setParameter("total", price * quantity)
                .setParameter("cart_id", cartId)
                .executeUpdate();
        session.flush();
    }

    public List getCart(String cartId) {
        String sql =/*"SELECT * FROM content WHERE content_id " +
                "in (SELECT content_id FROM cart_details a INNER JOIN cart b WHERE b.cart_id=:cart_id AND a.cart_id=b.cart_id GROUP BY a.content_id)";*/
                "SELECT content_id,quantity FROM cart_details a INNER JOIN cart b WHERE b.cart_id="
                        + ":cart_id AND a.cart_id=b.cart_id GROUP BY a.content_id";
        return getSession().createSQLQuery(sql)
                .setParameter("cart_id", cartId)
                .list();
    }

    //购买功能:1.生成订单和订单详情2.清空购物车
    public String purchase(String[] ids, String quantityList, String username) {
        Session session = getSession();

        JSONArray quantityArray = JSONArray.parseArray(quantityList);
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderId(MD5Code.getMD5("orderId" + System.currentTimeMillis()));
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderBean.setTime(dateFm.format(new Date()));
        orderBean.setUserId(username);

        int total = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<OrderDetailsBean> orderDetailList = new ArrayList<OrderDetailsBean>();

        for (int i = 0; i < ids.length; i++) {
            String contentId = ids[i];
            Integer qua = (Integer) quantityArray.get(i);
            map.put(contentId, qua);

            OrderDetailsBean orderDetail = new OrderDetailsBean();
            orderDetail.setOdetailsId(MD5Code.getMD5("orderDetail" + qua * System.currentTimeMillis()));
            orderDetail.setOrderId(orderBean.getOrderId());
            orderDetail.setContentId(contentId);
            orderDetail.setQuantity(qua);

            /*String sql="SELECT title,content_pic,price FROM content WHERE content_id=:content_id";*/
            ContentBean contentBean = (ContentBean) session
                    .createQuery("FROM ContentBean WHERE contentId=?").setParameter(0, contentId).uniqueResult();

            //orderDetail添加标题、价格、图片
            orderDetail.setTitle(contentBean.getTitle());
            orderDetail.setContentPic(contentBean.getContentPic());
            orderDetail.setPrice(contentBean.getPrice());

            orderDetailList.add(orderDetail);
            total += qua * contentBean.getPrice();
        }


        orderBean.setTotal(total);

        CartBean cart = new CartBean();
        String cartId = MD5Code.getMD5("cart" + System.currentTimeMillis());
        cart.setCartId(cartId);
        cart.setTotal(0);
        cart.setUserId(username);


        session.save(orderBean);
        session.save(cart);
        for (int i = 0; i < orderDetailList.size(); i++) {
            session.save(orderDetailList.get(i));
        }
        session
                .createQuery("UPDATE UserBean SET cartId=? WHERE userId=?")
                .setParameter(0, cart.getCartId())
                .setParameter(1, cart.getUserId())
                .executeUpdate();
        session.flush();
        return cartId;
    }

}
