package cn.zm.trip.web.test;

import cn.zm.trip.web.controller.OrderController;
import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.dao.OrderMapper;
import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.impl.OrderServiceImpl;
import org.easymock.EasyMock;
import org.junit.Test;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OrderControllerTest {

    OrderController orderController = new OrderController();
    UserService userService = createMock(UserService.class);
    OrderMapper orderdao = createMock(OrderMapper.class);
    ViewPointDao viewPointDao = createMock(ViewPointDao.class);
    HotelDao hotelDao =createMock(HotelDao.class);
    TrafficDao trafficDao =createMock(TrafficDao.class);
    HttpSession session = createMock(HttpSession.class);

    @Test
    public void orderPage() {
        Integer uid = 1;
        List<Order> expectList = new ArrayList<>();
        expectList.add(new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        expectList.add(new Order("A102", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        User user = new User();
        user.setPhone("1234567");
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setTpPrice("100");
        Hotel hotel = new Hotel();
        hotel.setPrice("100");
        Traffic traffic = new Traffic();
        traffic.setTpTprice("100");

        EasyMock.expect(userService.findUser("1")).andReturn(null);
        EasyMock.replay(userService);
        orderController.setUserService(userService);
        String url = orderController.orderPage("attraction","1","1");
        assertEquals(url, "redirect:/index");


    }

    @Test
    public void orderPage2() {
        Integer uid = 1;
        List<Order> expectList = new ArrayList<>();
        expectList.add(new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        expectList.add(new Order("A102", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        User user = new User();
        user.setPhone("1234567");
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setTpPrice("100");
        Hotel hotel = new Hotel();
        hotel.setPrice("100");
        Traffic traffic = new Traffic();
        traffic.setTpTprice("100");

        EasyMock.expect(userService.findUser("1")).andReturn(user);
        EasyMock.expect(viewPointDao.selectByPrimaryKey(1)).andReturn(viewPoint);
        session.setAttribute("order",viewPoint);
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(userService);
        EasyMock.replay(viewPointDao);
        orderController.setUserService(userService);
        orderController.setViewPointDao(viewPointDao);
        orderController.setSession(session);
        String url = orderController.orderPage("attraction","1","1");
        assertEquals(url, "proscenium/order/attractionContent");


    }
    @Test
    public void orderPage3() {
        Integer uid = 1;
        List<Order> expectList = new ArrayList<>();
        expectList.add(new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        expectList.add(new Order("A102", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        User user = new User();
        user.setPhone("1234567");
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setTpPrice("100");
        Hotel hotel = new Hotel();
        hotel.setPrice("100");
        Traffic traffic = new Traffic();
        traffic.setTpTprice("100");

        EasyMock.expect(userService.findUser("1")).andReturn(user);
        EasyMock.expect(hotelDao.selectByPrimaryKey(1)).andReturn(hotel);
        session.setAttribute("order",hotel);
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(userService);
        EasyMock.replay(hotelDao);
        orderController.setUserService(userService);
        orderController.setHotelDao(hotelDao);
        orderController.setSession(session);
        String url = orderController.orderPage("hotel","1","1");
        assertEquals(url, "proscenium/order/hotelContent");


    }
    @Test
    public void orderPage4() {
        Integer uid = 1;
        List<Order> expectList = new ArrayList<>();
        expectList.add(new Order("A101", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        expectList.add(new Order("A102", 1, "西湖#杭州#123@zjut.cn#15306591425#213#20210305#21:25:23#132156#15165#1", "123"));
        User user = new User();
        user.setPhone("1234567");
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setTpPrice("100");
        Hotel hotel = new Hotel();
        hotel.setPrice("100");
        Traffic traffic = new Traffic();
        traffic.setTpTprice("100");

        EasyMock.expect(userService.findUser("1")).andReturn(user);
        session.setAttribute("order",hotel);
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(userService);
        orderController.setUserService(userService);
        orderController.setSession(session);
        String url = orderController.orderPage("Traffic","1","1");
        assertEquals(url, "proscenium/order/trafficContent");


    }

    @Test
    public void createOrder() {

    }

    @Test
    public void updateOrder() {
    }

    @Test
    public void cancelOrder() {
    }
}