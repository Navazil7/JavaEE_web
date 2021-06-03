package cn.zm.trip.web.service;

import cn.zm.trip.web.dao.AdminDao;
import cn.zm.trip.web.domain.Admin;
import cn.zm.trip.web.service.impl.AdminServiceImpl;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//       "classpath:spring-context.xml"
//        ,"classpath:spring-mvc.xml"
////        ,"classpath:spring-context-druid.xml"
////        ,"classpath:spring-context-mybatis.xml"
//})
//@WebAppConfiguration

public class AdminServiceTest {


    @Test
    public void login() {
//        AdminService adminService = createMock(AdminService.class);
        AdminDao adminDao = createMock(AdminDao.class);
        AdminServiceImpl adminService = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setAemail("123");
        admin.setApwd("123");
        EasyMock.expect(adminDao.selectAdmin(new Admin("123", "123"))).andReturn(admin);

        //EasyMock.anyObject( Admin.class );

        EasyMock.replay(adminDao);

        //增加set方法
        adminService.setAdminDao(adminDao);

        //已重写Admin的equals方法，如果不重写会报错，详见https://www.cnblogs.com/niaomingjian/p/5437920.html
        Admin admin2 = adminService.login("123", "123");

        assertEquals(admin, admin2);

        EasyMock.verify(adminDao);
    }

    @Test
    public void selectAll() {
    }
}