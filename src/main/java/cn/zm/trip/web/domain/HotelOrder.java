package cn.zm.trip.web.domain;

public class HotelOrder {
    public String hotel_orderId; // 订单号
    public int hotel_uid; //用户Id
    public String hotel_name; //景点名称
    public String hotel_place; //景点地点
    public String hotel_room; //房间号
    public String hotel_uemail; //邮箱
    public String hotel_uphone; //手机
    public int hotel_cost; //金额
    public String hotel_createDate; //订单创建日期
    public String hotel_createTime; //订单创建时间
    public String hotel_time; //订单时效

    public Integer hotel_hid;  //酒店编号

    public Integer getHotel_hid() {
        return hotel_hid;
    }

    public void setHotel_hid(Integer hotel_hid) {
        this.hotel_hid = hotel_hid;
    }

    public String getHotel_orderId() {
        return hotel_orderId;
    }

    public void setHotel_orderId(String hotel_orderId) {
        this.hotel_orderId = hotel_orderId;
    }

    public int getHotel_uid() {
        return hotel_uid;
    }

    public void setHotel_uid(int hotel_uid) {
        this.hotel_uid = hotel_uid;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_place() {
        return hotel_place;
    }

    public void setHotel_place(String hotel_place) {
        this.hotel_place = hotel_place;
    }

    public String getHotel_room() {
        return hotel_room;
    }

    public void setHotel_room(String hotel_room) {
        this.hotel_room = hotel_room;
    }

    public String getHotel_uemail() {
        return hotel_uemail;
    }

    public void setHotel_uemail(String hotel_uemail) {
        this.hotel_uemail = hotel_uemail;
    }

    public String getHotel_uphone() {
        return hotel_uphone;
    }

    public void setHotel_uphone(String hotel_uphone) {
        this.hotel_uphone = hotel_uphone;
    }

    public int getHotel_cost() {
        return hotel_cost;
    }

    public void setHotel_cost(int hotel_cost) {
        this.hotel_cost = hotel_cost;
    }

    public String getHotel_createDate() {
        return hotel_createDate;
    }

    public void setHotel_createDate(String hotel_createDate) {
        this.hotel_createDate = hotel_createDate;
    }

    public String getHotel_createTime() {
        return hotel_createTime;
    }

    public void setHotel_createTime(String hotel_createTime) {
        this.hotel_createTime = hotel_createTime;
    }

    public String getHotel_time() {
        return hotel_time;
    }

    public void setHotel_time(String hotel_time) {
        this.hotel_time = hotel_time;
    }
}
