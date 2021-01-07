package cn.zm.trip.web.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Reply implements Serializable {

    //回复信息编号
    private int tp_rid;
    //回复人
    private String tp_rname;
    //回复时间
    private String tp_rdate;
    //回复内容
    private String tp_rcontent;
    //给谁回复
    private String tp_r_for_name;
    //哪个留言的回复
    private String tp_r_for_words;
    //哪个回复的回复
    private String tp_r_for_reply;
    //在哪个景点下的回复
    private String tp_r_viewpointId;
    //在哪个帖子的回复
    private String tp_r_forumId;
    //在哪个酒店的回复
    private String tp_r_hotelId;

    public int getTp_rid() {
        return tp_rid;
    }

    public void setTp_rid(int tp_rid) {
        this.tp_rid = tp_rid;
    }

    public String getTp_rname() {
        return tp_rname;
    }

    public void setTp_rname(String tp_rname) {
        this.tp_rname = tp_rname;
    }

    public String getTp_rdate() {
        return tp_rdate;
    }

    public void setTp_rdate(String tp_rdate) {
        this.tp_rdate = tp_rdate;
    }

    public String getTp_rcontent() {
        return tp_rcontent;
    }

    public void setTp_rcontent(String tp_rcontent) {
        this.tp_rcontent = tp_rcontent;
    }

    public String getTp_r_for_name() {
        return tp_r_for_name;
    }

    public void setTp_r_for_name(String tp_r_for_name) {
        this.tp_r_for_name = tp_r_for_name;
    }

    public String getTp_r_for_words() {
        return tp_r_for_words;
    }

    public void setTp_r_for_words(String tp_r_for_words) {
        this.tp_r_for_words = tp_r_for_words;
    }

    public String getTp_r_for_reply() {
        return tp_r_for_reply;
    }

    public void setTp_r_for_reply(String tp_r_for_reply) {
        this.tp_r_for_reply = tp_r_for_reply;
    }

    public String getTp_r_viewpointId() {
        return tp_r_viewpointId;
    }

    public void setTp_r_viewpointId(String tp_r_viewpointId) {
        this.tp_r_viewpointId = tp_r_viewpointId;
    }

    public String getTp_r_forumId() {
        return tp_r_forumId;
    }

    public void setTp_r_forumId(String tp_r_forumId) {
        this.tp_r_forumId = tp_r_forumId;
    }

    public String getTp_r_hotelId() {
        return tp_r_hotelId;
    }

    public void setTp_r_hotelId(String tp_r_hotelId) {
        this.tp_r_hotelId = tp_r_hotelId;
    }
}

