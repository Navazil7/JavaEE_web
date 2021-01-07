package cn.zm.trip.web.domain;

import org.springframework.stereotype.Component;


public class AttractionOrder {
    public String attr_orderId; // 订单号
    public int attr_uid; //用户Id
    public String attr_name; //景点名称
    public String attr_place; //景点地点
    public String attr_uemail; //邮箱
    public String attr_uphone; //手机
    public int attr_cost; //金额
    public String attr_createDate; //订单创建日期
    public String attr_createTime; //订单创建时间
    public String attr_time; //订单时效

    public Integer attr_vid; //景点id

    public Integer getAttr_vid() {
        return attr_vid;
    }

    public void setAttr_vid(Integer attr_vid) {
        this.attr_vid = attr_vid;
    }

    public String getAttr_orderId() {
        return attr_orderId;
    }

    public void setAttr_orderId(String attr_orderId) {
        this.attr_orderId = attr_orderId;
    }

    public int getAttr_uid() {
        return attr_uid;
    }

    public void setAttr_uid(int attr_uid) {
        this.attr_uid = attr_uid;
    }

    public String getAttr_name() {
        return attr_name;
    }

    public void setAttr_name(String attr_name) {
        this.attr_name = attr_name;
    }

    public String getAttr_place() {
        return attr_place;
    }

    public void setAttr_place(String attr_place) {
        this.attr_place = attr_place;
    }

    public String getAttr_uemail() {
        return attr_uemail;
    }

    public void setAttr_uemail(String attr_uemail) {
        this.attr_uemail = attr_uemail;
    }

    public String getAttr_uphone() {
        return attr_uphone;
    }

    public void setAttr_uphone(String attr_uphone) {
        this.attr_uphone = attr_uphone;
    }

    public int getAttr_cost() {
        return attr_cost;
    }

    public void setAttr_cost(int attr_cost) {
        this.attr_cost = attr_cost;
    }

    public String getAttr_createDate() {
        return attr_createDate;
    }

    public void setAttr_createDate(String attr_createDate) {
        this.attr_createDate = attr_createDate;
    }

    public String getAttr_createTime() {
        return attr_createTime;
    }

    public void setAttr_createTime(String attr_createTime) {
        this.attr_createTime = attr_createTime;
    }

    public String getAttr_time() {
        return attr_time;
    }

    public void setAttr_time(String attr_time) {
        this.attr_time = attr_time;
    }
}
