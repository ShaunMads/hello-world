package com.netease.sellsystem.bean;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class OrderBean {
    private String orderId;
    private String time;
    private Integer total;
    private String userId;
    private Integer status;
    private String key1;
    private String key2;
    private String key3;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderBean orderBean = (OrderBean) o;

        if (orderId != null ? !orderId.equals(orderBean.orderId) : orderBean.orderId != null) return false;
        if (time != null ? !time.equals(orderBean.time) : orderBean.time != null) return false;
        if (total != null ? !total.equals(orderBean.total) : orderBean.total != null) return false;
        if (userId != null ? !userId.equals(orderBean.userId) : orderBean.userId != null) return false;
        if (status != null ? !status.equals(orderBean.status) : orderBean.status != null) return false;
        if (key1 != null ? !key1.equals(orderBean.key1) : orderBean.key1 != null) return false;
        if (key2 != null ? !key2.equals(orderBean.key2) : orderBean.key2 != null) return false;
        if (key3 != null ? !key3.equals(orderBean.key3) : orderBean.key3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (key1 != null ? key1.hashCode() : 0);
        result = 31 * result + (key2 != null ? key2.hashCode() : 0);
        result = 31 * result + (key3 != null ? key3.hashCode() : 0);
        return result;
    }
}
