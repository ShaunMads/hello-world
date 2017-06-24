package com.netease.sellsystem.dao;

import com.netease.sellsystem.bean.ContentBean;

import java.util.List;

/**
 * Created by Shaun on 2017/3/8 0008.
 */
public interface ContentDao {
    List getContents(int pageSize, int page);

    List getNonBought(int pageSize, int page);

    void saveContent(ContentBean contentBean);

    Integer getTotalPage(int pageSize);

    Integer getNonBoughtTotalPage(int pageSize);

    void deleteContent(String nid);

    void updateContent(ContentBean contentBean);

    ContentBean getContentById(String nid);
}
