package cn.zm.trip.web.test;
import cn.zm.trip.web.controller.AdminController;
import cn.zm.trip.web.dao.UserDao;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.impl.UserServiceImpl;
import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void userSearch(){
        User user = new User();
        user.setUid("123");
        user.setUname("123");
        user.setUemail("123");
        UserServiceImpl userService = new UserServiceImpl();
        UserDao userDao = EasyMock.createMock(UserDao.class);

        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setUemail("123");
        user1.setUname("456");
        User user2 = new User();
        user2.setUemail("qqq");
        user2.setUname("123");
        list.add(user1);
        list.add(user2);

        EasyMock.expect(userDao.search(user)).andReturn(list);
        EasyMock.replay(userDao);
        userService.setUserDao(userDao);

        List<User> list2 = userService.search("123");

        //返回列表中是否都含有123关键字
        for(User u : list2){
            assertTrue(u.getUemail().equals("123") || u.getUname().equals("123") || u.getUid().equals("123"));
        }
    }

    @Test
    public void viewPointSearch() {
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setTpVname("杭州");
        viewPoint.setTpVtype("杭州");
        viewPoint.setTpLocation("杭州");

        List<ViewPoint> list = new ArrayList<ViewPoint>();
        ViewPoint viewPoint1 = new ViewPoint();
        viewPoint1.setTpVname("浙江工业大学");
        viewPoint1.setTpVtype("大学");
        viewPoint1.setTpLocation("杭州");
        ViewPoint viewPoint2 = new ViewPoint();
        viewPoint2.setTpVname("西湖");
        viewPoint2.setTpVtype("景区");
        viewPoint2.setTpLocation("杭州");
        list.add(viewPoint1);
        list.add(viewPoint2);

        AdminController adminController = new AdminController();
        ViewPointDao viewPointDao = EasyMock.createMock(ViewPointDao.class);

        EasyMock.expect(viewPointDao.viewPointSearch(viewPoint)).andReturn(list);
        EasyMock.replay(viewPointDao);

        adminController.setViewPointDao(viewPointDao);

        Model model = new Model() {
            @Override
            public Model addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        EasyMock.anyObject( Model.class );


        adminController.viewPointSearch("杭州", model);

    }
}
