package com.netease.sellsystem.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Shaun on 2017/3/7 0007.
 */
public interface BuyerDao {
    boolean isExit(String username, String password);
    List getUserInfo(String username, String password);
}
