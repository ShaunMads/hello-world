package com.netease.sellsystem.dao.impl;

import com.netease.sellsystem.dao.BuyerDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shaun on 2017/3/7 0007.
 */
@Component
@Transactional
public class BuyerDaoImpl implements BuyerDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean isExit(String username, String password) {
        return getSession()
                .createQuery("from UserBean where userId=? and password=?")
                .setParameter(0, username)
                .setParameter(1, password)
                .list()
                .size() > 0;
    }


    public List getUserInfo(String username, String password) {
        String sql = "SELECT nickname,cart_id,user_type,user_id FROM user WHERE user_id=:userId AND password=:password";
        return getSession()
                .createSQLQuery(sql)
                .setParameter("userId", username)
                .setParameter("password", password)
                .list();
    }

}
