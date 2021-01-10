package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface OrderService {
    /**
     *新增订单
     */
    void insertOrder(String oid, int uid, String info, String status);

    /**
     * 删除订单
     */
    void deleteOrder(String oid);

    /**
     * 查找所有订单
     */
    List<Order> findOrdersByUid(int uid);

    /**
     *查找订单
     */
    Order findOrderByOid(String oid);

    /**
     * 读取某一用户的所有订单
     */
    public List<Order> getAllOrders(int uid);

    /**
     * 读取某一用户的景点订单
     */
    public List<AttractionOrder> getAtrractions(int uid);

    /**
     * 读取某一用户的酒店订单
     */
    public List<HotelOrder> getHotels(int uid);

    /**
     * 读取某一用户的交通订单
     */
    public List<TrafficOrder> getTraffics(int uid);

    /**
     * 更新订单
     */
    public void updateOrder(Order order);
}
