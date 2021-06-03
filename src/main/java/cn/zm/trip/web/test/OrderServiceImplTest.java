package cn.zm.trip.web.test;

import cn.zm.trip.web.dao.OrderMapper;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.OrderService;
import cn.zm.trip.web.service.impl.OrderServiceImpl;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    OrderServiceImpl orderService = new OrderServiceImpl();
    OrderMapper orderdao = createMock(OrderMapper.class);
    ArrayList<Order> orderArrayList = new ArrayList<>();

    void initOrder(){
        orderArrayList.add(new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        orderArrayList.add(new Order("A102", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        orderArrayList.add(new Order("H105", 2, "酒店#杭州#123@zjut.cn#165165#152#20120302#12:23:52#12:58:45#2#1#556", "123"));
        orderArrayList.add(new Order("T110", 3, "公交车#123@zjut.cn#165165#杭州#宁波#20210203#12:23:52#20210302#12:53:36#152#20120302#12:23:52#2#1", "123"));
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void findOrdersByUid() {
        Integer uid = 1;
        initOrder();
        List<Order> expectList = new ArrayList<>();
        expectList.add(new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        expectList.add(new Order("A102", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));

        EasyMock.expect(orderdao.findOrdersByUid(1)).andReturn(expectList);
        EasyMock.replay(orderdao);
        orderService.setOrderdao(orderdao);
        List<Order> realList = orderService.findOrdersByUid(uid);
        for(Order o : realList)
            System.out.println(o);
        assertEquals(expectList,realList);

    }


    @Test
    public void findOrderByOid() {
        String oid = "A101";
        initOrder();
        Order expectOrder = new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123");

        EasyMock.expect(orderdao.selectByPrimaryKey("A101")).andReturn(expectOrder);
        EasyMock.replay(orderdao);
        orderService.setOrderdao(orderdao);
        Order realOrder = orderService.findOrderByOid(oid);
        System.out.println(realOrder);
        assertEquals(expectOrder,realOrder);
    }


    @Test
    public void getAtrractions() {
        initOrder();
        List<Order> expectList = new ArrayList();
        expectList.add(new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        expectList.add(new Order("A102", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));

        List<AttractionOrder> attractionOrderList = new ArrayList<>();
        for(Order order : expectList){

            AttractionOrder attraction = new AttractionOrder();
            attraction.attr_orderId=order.getTpOid();
            attraction.attr_uid=order.getTpUid();
            String[] infos = order.getTpOinfo().split("#");
            attraction.attr_name=infos[0].trim();
            attraction.attr_place=infos[1].trim();
            attraction.attr_uemail=infos[2].trim();
            attraction.attr_uphone=infos[3].trim();
            attraction.attr_cost=Integer.parseInt(infos[4].trim());
            attraction.attr_createDate=infos[5].trim();
            attraction.attr_createTime=infos[6].trim();
            attraction.attr_time=infos[7].trim();
            attraction.attr_vid=Integer.parseInt(infos[8].trim());
            attraction.attr_num=Integer.parseInt(infos[9].trim());
            attractionOrderList.add(attraction);
        }
        EasyMock.expect(orderdao.findOrdersByUid(1)).andReturn(expectList);
        EasyMock.replay(orderdao);
        orderService.setOrderdao(orderdao);
        List<AttractionOrder> realList = orderService.getAtrractions(1);
        for(AttractionOrder o : attractionOrderList) System.out.println(o);
        for(int i=0;i<attractionOrderList.size();i++)
            assertEquals(attractionOrderList.get(i),realList.get(i));
    }

    @Test
    public void getHotels() {
        initOrder();
        List<Order> expectList = new ArrayList();
        expectList.add(new Order("H105", 2, "酒店#杭州#123@zjut.cn#165165#152#20120302#12:23:52#12:58:45#2#1#556", "123"));
        List<HotelOrder> list_hotels = new ArrayList<>();
        for(Order order : expectList){
            HotelOrder hotel=new HotelOrder();
            hotel.hotel_orderId=order.getTpOid();
            hotel.hotel_uid=order.getTpUid();
            String info=order.getTpOinfo();
            String[] infos=info.split("#");
            hotel.hotel_name=infos[0].trim();
            hotel.hotel_place=infos[1].trim();
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
        EasyMock.expect(orderdao.findOrdersByUid(2)).andReturn(expectList);
        EasyMock.replay(orderdao);
        orderService.setOrderdao(orderdao);
        List<HotelOrder> realList = orderService.getHotels(2);
        for(HotelOrder o : realList) System.out.println(o);
        for(int i=0;i<list_hotels.size();i++)
            assertEquals(list_hotels.get(i),realList.get(i));
    }

    @Test
    public void getTraffics() {
        initOrder();
        List<Order> expectList = new ArrayList();
        expectList.add(new Order("T110", 3, "公交车#123@zjut.cn#165165#杭州#宁波#20210203#12:23:52#20210302#12:53:36#152#20120302#12:23:52#2#1", "123"));
        List<TrafficOrder> list_traffics = new ArrayList<>();
        for(Order order : expectList){
            TrafficOrder traffic=new TrafficOrder();
            traffic.traffic_orderId=order.getTpOid();
            traffic.traffic_uid=order.getTpUid();
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
        EasyMock.expect(orderdao.findOrdersByUid(3)).andReturn(expectList);
        EasyMock.replay(orderdao);
        orderService.setOrderdao(orderdao);
        List<TrafficOrder> realList = orderService.getTraffics(3);
        for(TrafficOrder o : realList) System.out.println(o);
        for(int i=0;i<list_traffics.size();i++)
            assertEquals(list_traffics.get(i),realList.get(i));
    }

}