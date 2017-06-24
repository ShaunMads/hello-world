package com.netease.sellsystem.bean;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class ContentBean {
    private String contentId;
    private String title;
    private String contentPic;
    private String summary;
    private String text;
    private String userId;
    private Integer price;
    private Integer saleQuantity;
    private String key1;//内容状态：0-未购买，2-已购买
    private String key2;
    private String key3;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentPic() {
        return contentPic;
    }

    public void setContentPic(String contentPic) {
        this.contentPic = contentPic;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
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

        ContentBean that = (ContentBean) o;

        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (contentPic != null ? !contentPic.equals(that.contentPic) : that.contentPic != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (saleQuantity != null ? !saleQuantity.equals(that.saleQuantity) : that.saleQuantity != null) return false;
        if (key1 != null ? !key1.equals(that.key1) : that.key1 != null) return false;
        if (key2 != null ? !key2.equals(that.key2) : that.key2 != null) return false;
        if (key3 != null ? !key3.equals(that.key3) : that.key3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contentId != null ? contentId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (contentPic != null ? contentPic.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (saleQuantity != null ? saleQuantity.hashCode() : 0);
        result = 31 * result + (key1 != null ? key1.hashCode() : 0);
        result = 31 * result + (key2 != null ? key2.hashCode() : 0);
        result = 31 * result + (key3 != null ? key3.hashCode() : 0);
        return result;
    }
}
