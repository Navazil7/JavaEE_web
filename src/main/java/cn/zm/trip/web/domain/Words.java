package cn.zm.trip.web.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 留言信息
 * @author TyCoding
 * @date 2018/5/6 上午10:56
 */
@Component
public class Words implements Serializable {

    //编号
    private Integer tp_wid;
    //留言人
    private String tp_wname;
    //留言时间
    private String tp_wdate;
    //留言内容
    private String tp_wcontent;
    //给谁留言
    private String tp_w_for_name;
    //在哪个景点留言(id)
    private String tp_w_viewpointId;
    //在哪篇文章留言(id)
    private String tp_w_forumId;
    //在哪家酒店留言(id)
    private String tp_w_hotelId;

    public Integer getTp_wid() {
        return tp_wid;
    }

    public void setTp_wid(Integer tp_wid) {
        this.tp_wid = tp_wid;
    }

    public String getTp_wname() {
        return tp_wname;
    }

    public void setTp_wname(String tp_wname) {
        this.tp_wname = tp_wname;
    }

    public String getTp_wdate() {
        return tp_wdate;
    }

    public void setTp_wdate(String tp_wdate) {
        this.tp_wdate = tp_wdate;
    }

    public String getTp_wcontent() {
        return tp_wcontent;
    }

    public void setTp_wcontent(String tp_wcontent) {
        this.tp_wcontent = tp_wcontent;
    }

    public String getTp_w_for_name() {
        return tp_w_for_name;
    }

    public void setTp_w_for_name(String tp_w_for_name) {
        this.tp_w_for_name = tp_w_for_name;
    }

    public String getTp_w_viewpointId() {
        return tp_w_viewpointId;
    }

    public void setTp_w_viewpointId(String tp_w_viewpointId) {
        this.tp_w_viewpointId = tp_w_viewpointId;
    }

    public String getTp_w_forumId() {
        return tp_w_forumId;
    }

    public void setTp_w_forumId(String tp_w_forumId) {
        this.tp_w_forumId = tp_w_forumId;
    }

    public String getTp_w_hotelId() {
        return tp_w_hotelId;
    }

    public void setTp_w_hotelId(String tp_w_hotelId) {
        this.tp_w_hotelId = tp_w_hotelId;
    }
}
