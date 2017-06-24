package com.netease.sellsystem.bean;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class CartBean {
    private String cartId;
    private String userId;
    private Integer total;
    private String key1;
    private String key2;
    private String key3;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

        CartBean cartBean = (CartBean) o;

        if (cartId != null ? !cartId.equals(cartBean.cartId) : cartBean.cartId != null) return false;
        if (userId != null ? !userId.equals(cartBean.userId) : cartBean.userId != null) return false;
        if (total != null ? !total.equals(cartBean.total) : cartBean.total != null) return false;
        if (key1 != null ? !key1.equals(cartBean.key1) : cartBean.key1 != null) return false;
        if (key2 != null ? !key2.equals(cartBean.key2) : cartBean.key2 != null) return false;
        if (key3 != null ? !key3.equals(cartBean.key3) : cartBean.key3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (key1 != null ? key1.hashCode() : 0);
        result = 31 * result + (key2 != null ? key2.hashCode() : 0);
        result = 31 * result + (key3 != null ? key3.hashCode() : 0);
        return result;
    }
}
