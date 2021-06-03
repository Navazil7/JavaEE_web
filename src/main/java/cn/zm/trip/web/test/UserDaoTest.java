package cn.zm.trip.web.test;

import cn.zm.trip.web.dao.UserDao;
import cn.zm.trip.web.domain.Traffic;
import cn.zm.trip.web.domain.User;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
//import javax.jws.soap.SOAPBinding;

import java.util.*;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

public class UserDaoTest {

    @Resource
    private UserDao userDao;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertUser() {
        UserDao userDao= EasyMock.createMock(UserDao.class);
        User user1=new User();
        user1.setUid("1");
        user1.setUname("wjk");
        user1.setUemail("wjk@zjut.cn");
        expect(userDao.insert(user1)).andReturn(1);
        EasyMock.replay(userDao);
        int answer=userDao.insert(user1);
        assertEquals(1, answer);
        EasyMock.verify(userDao);
    }
    @Test
    //用户已存在
    public void insertUserFail() {
        UserDao userDao= EasyMock.createMock(UserDao.class);
        User user1=new User();
        user1.setUid("1");
        user1.setUname("wjk");
        user1.setUemail("wjk@zjut.cn");
        expect(userDao.insert(user1)).andReturn(0);
        EasyMock.replay(userDao);
        int answer=userDao.insert(user1);
        assertEquals(0, answer);
        EasyMock.verify(userDao);
    }

    @Test
    public void selectAll() {
        UserDao userDao= EasyMock.createMock(UserDao.class);
        User user1=new User();
        user1.setUid("1");
        user1.setUname("wjk");
        user1.setUemail("wjk@zjut.cn");
        User user2=new User();
        user2.setUid("2");
        user2.setUname("xlb");
        user2.setUemail("xlb@zjut.cn");
        List<User> userList1=new ArrayList<User>();
        userList1.add(user1);
        userList1.add(user2);
        expect(userDao.insert(user1)).andReturn(1);
        expect(userDao.insert(user2)).andReturn(1);
        expect(userDao.selectAll()).andReturn(userList1);
        EasyMock.replay(userDao);
        userDao.insert(user1);
        userDao.insert(user2);
        List<User>userList2=userDao.selectAll();
        for(int i=0;i<2;i++)
            assertEquals(userList2.get(i), userList1.get(i));
        EasyMock.verify(userDao);
    }



    @Test
    public void updataUserInfo() {
        UserDao userDao= EasyMock.createMock(UserDao.class);
        User user1=new User();
        user1.setUid("1");
        user1.setUname("wjk");
        userDao.updataUserInfo(user1);
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(userDao);
        EasyMock.verify(userDao);
    }


    @Test
    public void deleteByPrimaryKey() {

        UserDao userDao= EasyMock.createMock(UserDao.class);
        User user1=new User();
        user1.setUid("1");
        user1.setUname("wjk");
        expect(userDao.deleteByPrimaryKey(1)).andReturn(1);
        EasyMock.replay(userDao);
        int answer=userDao.deleteByPrimaryKey(1);
        assertEquals(1, answer);
        EasyMock.verify(userDao);
    }
    //删除失败
    @Test
    public void deleteByPrimaryKeyFail() {

        UserDao userDao= EasyMock.createMock(UserDao.class);
        User user1=new User();
        user1.setUid("1");
        user1.setUname("wjk");

        expect(userDao.deleteByPrimaryKey(1)).andReturn(0);
        EasyMock.replay(userDao);
        int answer=userDao.deleteByPrimaryKey(1);
        assertEquals(0, answer);
        EasyMock.verify(userDao);
    }


}