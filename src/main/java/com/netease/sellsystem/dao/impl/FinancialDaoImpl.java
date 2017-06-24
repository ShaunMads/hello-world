package com.netease.sellsystem.dao.impl;

import com.netease.sellsystem.dao.FinancialDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shaun on 2017/3/8 0008.
 */
@Component
@Transactional
public class FinancialDaoImpl implements FinancialDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List getBoughtList(String username) {
        String sql = "SELECT title,content_pic,b.time,price,quantity FROM order_details a INNER JOIN `order` b " +
                "WHERE b.user_id=:user_id AND a.order_id=b.order_id ORDER BY b.time DESC";
        return getSession().createSQLQuery(sql)
                .setParameter("user_id", username)
                .list();
    }

}
