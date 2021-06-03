package cn.zm.trip.web.controller;

import cn.zm.trip.web.service.AdminService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//        //"classpath:spring-context.xml"
//        "classpath:spring-mvc.xml"
////        ,"classpath:spring-context-druid.xml"
////        ,"classpath:spring-context-mybatis.xml"
//})
//@WebAppConfiguration

public class AdminControllerTest {

    public static XmlWebApplicationContext context = null;
    public static String[] CONFIG_FILES = {"spring-mvc.xml"};

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new XmlWebApplicationContext();
        context.setConfigLocations(CONFIG_FILES);

        MockServletContext msc = new MockServletContext();
        context.setServletContext(msc);
        context.refresh();

        msc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        context.close();
    }

    @Autowired
    private AdminService adminService;

    @Test
    public void login() {
    }
}