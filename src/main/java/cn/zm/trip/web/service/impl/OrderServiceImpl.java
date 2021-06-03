package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.dao.OrderMapper;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderdao;

    public void setOrderdao(OrderMapper orderdao){
        this.orderdao = orderdao;
    }
    @Override
    public void insertOrder(String oid, int uid, String info,String status) {
        orderdao.insert(new Order(oid,uid,info,status));
    }

    @Override
    public void deleteOrder(String oid) {
        orderdao.deleteByPrimaryKey(oid);
    }

    @Override
    public List<Order> findOrdersByUid(int uid) {
        return orderdao.findOrdersByUid(uid);
    }

    @Override
    public Order findOrderByOid(String oid) {
        return orderdao.selectByPrimaryKey(oid);
    }

    @Override
    public List<Order> getAllOrders(int uid){
        return findOrdersByUid(uid);
    }

    @Override
    public List<AttractionOrder> getAtrractions(int uid){
        AttractionOrder attracion;
        List<Order> list_all=getAllOrders(uid);
        ArrayList<AttractionOrder> list_attractions = new ArrayList<>();
        if(list_all!=null)
            for(Order order : list_all){
                String type=order.getTpOid();
                System.out.println(type);
                if(type.charAt(0)=='A'){
                    attracion=new AttractionOrder();
                    attracion.attr_orderId=type;
                    attracion.attr_uid=uid;
                    String info=order.getTpOinfo();
                    String[] infos=info.split("#");
    //                System.out.println(infos.length);
    //                for(String s:infos) System.out.println(s);
                    attracion.attr_name=infos[0].trim();
                    attracion.attr_place=infos[1].trim();
                    attracion.attr_uemail=infos[2].trim();
                    attracion.attr_uphone=infos[3].trim();
                    attracion.attr_cost=Integer.parseInt(infos[4].trim());
                    attracion.attr_createDate=infos[5].trim();
                    attracion.attr_createTime=infos[6].trim();
                    attracion.attr_time=infos[7].trim();
                    attracion.attr_vid=Integer.parseInt(infos[8].trim());
                    attracion.attr_num=Integer.parseInt(infos[9].trim());
                    attracion.setAttr_status(order.getTpStatus().trim());
                    list_attractions.add(attracion);
                }


            }
        return list_attractions;
    }

    @Override
    public List<HotelOrder> getHotels(int uid) {
        HotelOrder hotel;
        List<Order> list_all=getAllOrders(uid);
        ArrayList<HotelOrder> list_hotels = new ArrayList<>();
        if(list_all!=null)
            for(Order order : list_all){
                String type=order.getTpOid();
                System.out.println(type);
                if(type.charAt(0)=='H'){
                    hotel=new HotelOrder();
                    hotel.hotel_orderId=type;
                    hotel.hotel_uid=uid;
                    String info=order.getTpOinfo();
                    String[] infos=info.split("#");
    //                System.out.println(infos.length);
    //                for(String s:infos) System.out.println(s);
                    hotel.hotel_name=infos[0].trim();
                    hotel.hotel_place=infos[1].trim();
    //                hotel.hotel_room=infos[2].trim();
                    hotel.hotel_uemail=infos[2].trim();
                    hotel.hotel_uphone=infos[3].trim();
                    hotel.hotel_cost=Integer.parseInt(infos[4].trim());
                    hotel.hotel_createDate=infos[5].trim();
                    hotel.hotel_createTime=infos[6].trim();
                    hotel.hotel_time=infos[7].trim();
                    hotel.hotel_hid=Integer.parseInt(infos[8].trim());
                    hotel.hotel_num=Integer.parseInt(infos[9].trim());
                    hotel.hotel_status=order.getTpStatus().trim();
                    list_hotels.add(hotel);
                }


            }
        return list_hotels;
    }

    @Override
    public List<TrafficOrder> getTraffics(int uid) {
        TrafficOrder traffic;
        List<Order> list_all=getAllOrders(uid);
        ArrayList<TrafficOrder> list_traffics = new ArrayList<>();
        if(list_all!=null)
            for(Order order : list_all){
                String type=order.getTpOid();
                System.out.println(type);
                if(type.charAt(0)=='T'){
                    traffic=new TrafficOrder();
                    traffic.traffic_orderId=type;
                    traffic.traffic_uid=uid;
                    String info=order.getTpOinfo();
                    String[] infos=info.split("#");
                    traffic.traffic_type=infos[0].trim();
                    traffic.traffic_uemail=infos[1].trim();
                    traffic.traffic_uphone=infos[2].trim();
                    traffic.traffic_depart=infos[3].trim();
                    traffic.traffic_des=infos[4].trim();
                    traffic.traffic_departDate=infos[5].trim();
                    traffic.traffic_departTime=infos[6].trim();
                    traffic.traffic_desDate=infos[7].trim();
                    traffic.traffic_desTime=infos[8].trim();
                    traffic.traffic_cost=Integer.parseInt(infos[9].trim());
                    traffic.traffic_createDate=infos[10].trim();
                    traffic.traffic_createTime=infos[11].trim();
                    traffic.traffic_tid=Integer.parseInt(infos[12].trim());
                    traffic.traffic_num=Integer.parseInt(infos[13].trim());
                    traffic.traffic_status=order.getTpStatus();
                    list_traffics.add(traffic);
                }


            }
        return list_traffics;
    }

    @Override
    public void updateOrder(Order order) {
        orderdao.updateByPrimaryKey(order);
    }
}
