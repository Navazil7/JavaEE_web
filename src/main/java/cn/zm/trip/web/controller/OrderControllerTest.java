package cn.zm.trip.web.controller;


import cn.zm.trip.web.controller.OrderController;
import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.dao.OrderMapper;
import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.impl.OrderServiceImpl;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/spring-mvc*.xml", "classpath*:/spring-context*.xml"})
public class OrderControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

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

//        EasyMock.expect(userService.findUser("1")).andReturn(null);
//        EasyMock.replay(userService);
//        orderController.setUserService(userService);
//        String url = orderController.orderPage("attraction","1","1");
//        assertEquals(url, "redirect:/index");

//        EasyMock.expect(userService.findUser("1")).andReturn(user);
//        EasyMock.expect(viewPointDao.selectByPrimaryKey(1)).andReturn(viewPoint);
//        session.setAttribute("order",viewPoint);
//        EasyMock.expectLastCall().anyTimes();
//        EasyMock.replay(userService);
//        EasyMock.replay(viewPointDao);
//        orderController.setUserService(userService);
//        orderController.setViewPointDao(viewPointDao);
//        orderController.setSession(session);
//        String url = orderController.orderPage("attraction","1","1");
//        assertEquals(url, "proscenium/order/attractionContent");

//        EasyMock.expect(userService.findUser("1")).andReturn(user);
//        EasyMock.expect(hotelDao.selectByPrimaryKey(1)).andReturn(hotel);
//        session.setAttribute("order",hotel);
//        EasyMock.expectLastCall().anyTimes();
//        EasyMock.replay(userService);
//        EasyMock.replay(hotelDao);
//        orderController.setUserService(userService);
//        orderController.setHotelDao(hotelDao);
//        orderController.setSession(session);
//        String url = orderController.orderPage("hotel","1","1");
//        assertEquals(url, "proscenium/order/hotelContent");

        EasyMock.expect(userService.findUser("1")).andReturn(user);
        session.setAttribute("order",hotel);
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(userService);
//        orderController.setUserService(userService);
//        orderController.setSession(session);
//        String url = orderController.orderPage("Traffic","1","1");
//        assertEquals(url, "proscenium/order/trafficContent");


    }

    @Test
    public void createOrder() {

    }

    @Test
    public void updateOrder() throws Exception {
        String responseString = mockMvc.perform(
                get("http://localhost:8080/order/update")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("key", "attraction")   //添加参数(可以添加多个)
                        .param("tpoid", "A0001")   //添加参数(可以添加多个)
                        .param("tpuid","11")
        )
                .andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
        String expectValue = "proscenium/order/attractionsOrder";
        assertEquals(expectValue,responseString);
    }

    @Test
    public void cancelOrder() {
    }
}

