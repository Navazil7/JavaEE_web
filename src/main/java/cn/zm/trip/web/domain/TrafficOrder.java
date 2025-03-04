package cn.zm.trip.web.domain;

import java.util.Objects;

public class TrafficOrder {
    public String traffic_orderId; // 订单号
    public int traffic_uid; //用户Id
    public String traffic_type; //交通类型
    public String traffic_uemail; //邮箱
    public String traffic_uphone; //手机
    public String traffic_depart; //出发地
    public String traffic_des; //目的地
    public String traffic_departDate; //出发日期
    public String traffic_departTime; //出发时间
    public String traffic_desDate; //达到日期
    public String traffic_desTime; //到达时间
    public int traffic_cost; //订单金额
    public String traffic_createDate; //订单创建日期
    public String traffic_createTime; //订单创建时间

    public Integer traffic_tid;  //交通编号
    public String traffic_status; //支付状态
    public Integer traffic_num;  //订单数量

    public Integer getTraffic_tid() {
        return traffic_tid;
    }

    public void setTraffic_tid(Integer traffic_tid) {
        this.traffic_tid = traffic_tid;
    }

    public String getTraffic_status() {
        return traffic_status;
    }

    public void setTraffic_status(String traffic_status) {
        this.traffic_status = traffic_status;
    }

    public Integer getTraffic_num() {
        return traffic_num;
    }

    public void setTraffic_num(Integer traffic_num) {
        this.traffic_num = traffic_num;
    }

    public String getTraffic_orderId() {
        return traffic_orderId;
    }

    public void setTraffic_orderId(String traffic_orderId) {
        this.traffic_orderId = traffic_orderId;
    }

    public int getTraffic_uid() {
        return traffic_uid;
    }

    public void setTraffic_uid(int traffic_uid) {
        this.traffic_uid = traffic_uid;
    }

    public String getTraffic_type() {
        return traffic_type;
    }

    public void setTraffic_type(String traffic_type) {
        this.traffic_type = traffic_type;
    }

    public String getTraffic_uemail() {
        return traffic_uemail;
    }

    public void setTraffic_uemail(String traffic_uemail) {
        this.traffic_uemail = traffic_uemail;
    }

    public String getTraffic_uphone() {
        return traffic_uphone;
    }

    public void setTraffic_uphone(String traffic_uphone) {
        this.traffic_uphone = traffic_uphone;
    }

    public String getTraffic_depart() {
        return traffic_depart;
    }

    public void setTraffic_depart(String traffic_depart) {
        this.traffic_depart = traffic_depart;
    }

    public String getTraffic_des() {
        return traffic_des;
    }

    public void setTraffic_des(String traffic_des) {
        this.traffic_des = traffic_des;
    }

    public String getTraffic_departDate() {
        return traffic_departDate;
    }

    public void setTraffic_departDate(String traffic_departDate) {
        this.traffic_departDate = traffic_departDate;
    }

    public String getTraffic_departTime() {
        return traffic_departTime;
    }

    public void setTraffic_departTime(String traffic_departTime) {
        this.traffic_departTime = traffic_departTime;
    }

    public String getTraffic_desDate() {
        return traffic_desDate;
    }

    public void setTraffic_desDate(String traffic_desDate) {
        this.traffic_desDate = traffic_desDate;
    }

    public String getTraffic_desTime() {
        return traffic_desTime;
    }

    public void setTraffic_desTime(String traffic_desTime) {
        this.traffic_desTime = traffic_desTime;
    }

    public String getTraffic_createDate() {
        return traffic_createDate;
    }

    public void setTraffic_createDate(String traffic_createDate) {
        this.traffic_createDate = traffic_createDate;
    }

    public String getTraffic_createTime() {
        return traffic_createTime;
    }

    public void setTraffic_createTime(String traffic_createTime) {
        this.traffic_createTime = traffic_createTime;
    }

    public int getTraffic_cost() {
        return traffic_cost;
    }

    public void setTraffic_cost(int traffic_cost) {
        this.traffic_cost = traffic_cost;
    }

    @Override
    public String toString() {
        return "Traffic{" +
                "toid=" + traffic_orderId +
                ", tuid='" + traffic_uid + '\'' +
                ", temail='" + traffic_uemail + '\'' +
                ", trafficid='" + traffic_tid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null||obj.getClass()!=this.getClass()) return false;
        TrafficOrder trafficOrder=(TrafficOrder) obj;
        return (this.getTraffic_num().equals(trafficOrder.getTraffic_num()))&&(this.getTraffic_tid().equals(trafficOrder.getTraffic_tid()))
                &&(this.getTraffic_uid()==trafficOrder.getTraffic_uid())&&(this.getTraffic_uemail().equals(trafficOrder.getTraffic_uemail()))
                &&(this.getTraffic_uphone().equals(trafficOrder.getTraffic_uphone()))&&(this.getTraffic_orderId().equals(trafficOrder.getTraffic_orderId()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTraffic_depart(),getTraffic_createDate(),getTraffic_departTime(),getTraffic_des(),getTraffic_desDate(),getTraffic_departTime(),getTraffic_cost(),getTraffic_createDate(),getTraffic_createTime(),getTraffic_orderId(),getTraffic_uemail(),getTraffic_uid(),getTraffic_uphone(),getTraffic_tid(),getTraffic_num(),getTraffic_status(),getTraffic_type());
    }
}
