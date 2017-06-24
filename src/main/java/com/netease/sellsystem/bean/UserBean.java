package com.netease.sellsystem.bean;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class UserBean {
    private String userId;
    private String password;
    private String headpic;
    private Integer type;//用户类型:1-buyer,0-seller
    private String cartId;
    private String name;
    private String key1;
    private String key2;
    private String key3;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        UserBean userBean = (UserBean) o;

        if (userId != null ? !userId.equals(userBean.userId) : userBean.userId != null) return false;
        if (password != null ? !password.equals(userBean.password) : userBean.password != null) return false;
        if (headpic != null ? !headpic.equals(userBean.headpic) : userBean.headpic != null) return false;
        if (type != null ? !type.equals(userBean.type) : userBean.type != null) return false;
        if (cartId != null ? !cartId.equals(userBean.cartId) : userBean.cartId != null) return false;
        if (name != null ? !name.equals(userBean.name) : userBean.name != null) return false;
        if (key1 != null ? !key1.equals(userBean.key1) : userBean.key1 != null) return false;
        if (key2 != null ? !key2.equals(userBean.key2) : userBean.key2 != null) return false;
        if (key3 != null ? !key3.equals(userBean.key3) : userBean.key3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (headpic != null ? headpic.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (key1 != null ? key1.hashCode() : 0);
        result = 31 * result + (key2 != null ? key2.hashCode() : 0);
        result = 31 * result + (key3 != null ? key3.hashCode() : 0);
        return result;
    }
}
