package cn.zm.trip.web.domain;

import org.springframework.stereotype.Component;

import java.util.Objects;


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
    public String attr_status; //支付状态
    public Integer attr_num;  //订单数量

    public Integer getAttr_num() {
        return attr_num;
    }

    public void setAttr_num(Integer attr_num) {
        this.attr_num = attr_num;
    }

    public String getAttr_status() {
        return attr_status;
    }

    public void setAttr_status(String attr_status) {
        this.attr_status = attr_status;
    }

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

    @Override
    public String toString() {
        return "Attraction{" +
                "aoid=" + attr_orderId +
                ", auid='" + attr_uid + '\'' +
                ", aemail='" + attr_uemail + '\'' +
                ", attracionid='" + attr_vid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null||obj.getClass()!=this.getClass()) return false;
        AttractionOrder attractionOrder=(AttractionOrder) obj;
        return (this.getAttr_num().equals(attractionOrder.getAttr_num()))&&(this.getAttr_vid().equals(attractionOrder.getAttr_vid()))
                &&(this.getAttr_uid()==attractionOrder.getAttr_uid())&&(this.getAttr_time().equals(attractionOrder.getAttr_time()))
                &&(this.getAttr_uemail().equals(attractionOrder.getAttr_uemail()))&&(this.getAttr_uphone().equals(attractionOrder.getAttr_uphone()))
        &&(this.getAttr_orderId().equals(attractionOrder.getAttr_orderId()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getAttr_cost(),getAttr_createDate(),getAttr_createTime(),getAttr_name(),getAttr_orderId(),getAttr_place(),getAttr_uemail(),getAttr_uid(),getAttr_uphone(),getAttr_vid(),getAttr_num(),getAttr_time(),getAttr_status());
    }
}
