package com.netease.sellsystem.bean;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class CartDetailsBean {
    private String cdetailsId;
    private String contentId;
    private Integer quantity;
    private String cartId;
    private String key1;
    private String key2;
    private String key3;

    public String getCdetailsId() {
        return cdetailsId;
    }

    public void setCdetailsId(String cdetailsId) {
        this.cdetailsId = cdetailsId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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

        CartDetailsBean that = (CartDetailsBean) o;

        if (cdetailsId != null ? !cdetailsId.equals(that.cdetailsId) : that.cdetailsId != null) return false;
        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (cartId != null ? !cartId.equals(that.cartId) : that.cartId != null) return false;
        if (key1 != null ? !key1.equals(that.key1) : that.key1 != null) return false;
        if (key2 != null ? !key2.equals(that.key2) : that.key2 != null) return false;
        if (key3 != null ? !key3.equals(that.key3) : that.key3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cdetailsId != null ? cdetailsId.hashCode() : 0;
        result = 31 * result + (contentId != null ? contentId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        result = 31 * result + (key1 != null ? key1.hashCode() : 0);
        result = 31 * result + (key2 != null ? key2.hashCode() : 0);
        result = 31 * result + (key3 != null ? key3.hashCode() : 0);
        return result;
    }
}
