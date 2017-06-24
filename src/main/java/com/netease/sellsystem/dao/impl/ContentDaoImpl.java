package com.netease.sellsystem.dao.impl;

import com.netease.sellsystem.bean.ContentBean;
import com.netease.sellsystem.dao.ContentDao;
import org.hibernate.Query;
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
public class ContentDaoImpl implements ContentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List getContents(int pageSize, int page) {
        Query query = getSession().createQuery("from ContentBean ");
        query.setMaxResults(pageSize);
        query.setFirstResult((page - 1) * pageSize);
        return query.list();
    }

    public List getNonBought(int pageSize, int page) {
        Query query = getSession().createQuery("from ContentBean where saleQuantity=0");
        query.setMaxResults(pageSize);
        query.setFirstResult((page - 1) * pageSize);
        return query.list();
    }

    public Integer getTotalPage(int pageSize) {
        Integer newsTotal = new Long((Long) getSession()
                .createQuery("select count(*) from ContentBean")
                .uniqueResult())
                .intValue();
        Integer TotalPage;
        if (newsTotal % pageSize != 0) {
            TotalPage = newsTotal / pageSize + 1;
        } else {
            TotalPage = newsTotal / pageSize;
        }
        return TotalPage;
    }

    public Integer getNonBoughtTotalPage(int pageSize) {
        Integer newsTotal = new Long((Long) getSession()
                .createQuery("select count(*) from ContentBean where saleQuantity=0")
                .uniqueResult())
                .intValue();
        Integer TotalPage;
        if (newsTotal % pageSize != 0) {
            TotalPage = newsTotal / pageSize + 1;
        } else {
            TotalPage = newsTotal / pageSize;
        }
        return TotalPage;
    }

    public ContentBean getContentById(String nid) {
        return (ContentBean) getSession()
                .get(ContentBean.class, nid);
    }

    public void saveContent(ContentBean contentBean) {
        Session session = getSession();
        session.save(contentBean);
        session.flush();
    }

    public void deleteContent(String nid) {
        getSession()
                .createQuery("delete from ContentBean where contentId=?")
                .setParameter(0, nid)
                .executeUpdate();
    }

    public void updateContent(ContentBean contentBean) {
        Session session = getSession();
        session.update(contentBean);
        session.flush();
    }

}
