package cn.zm.trip.web.test;

import cn.zm.trip.web.commons.MapDistance;
import cn.zm.trip.web.commons.ajaxcustData;
import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.ViewPointService;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustControllerTest {

    @Test
    public void viewPoint() {
        String tpLocation="杭州";

        List<ViewPoint> viewPointList=new ArrayList<ViewPoint>();
        ViewPoint viewPoint=new ViewPoint();
        viewPoint.setTpVid(1);
        viewPoint.setTpVname("杭州动物园");
        viewPointList.add(viewPoint);
        ViewPointExample example = new ViewPointExample();
        example.createCriteria().andTpVcityEqualTo(tpLocation);
        example.setOrderByClause("tp_vid desc");
        ViewPointService viewPointService=EasyMock.createMock(ViewPointService.class);
        EasyMock.expect(viewPointService.selectByExample(example)).andReturn(viewPointList);
        EasyMock.replay(viewPointService);
        List<ViewPoint> list=viewPointService.selectByExample(example);
        assertEquals(list.get(0),viewPointList.get(0));
        EasyMock.verify(viewPointService);
    }



    @Test
    public void viewPointCartAtuo() {
        String desCity="杭州";
        User user =new User();
        user.setUid("1");
        user.setTp_like("动物园");
        UserService userService=EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.userLikeVtype(user.getUid())).andReturn(user.getTp_like());
        EasyMock.replay(userService);
        String like = userService.userLikeVtype(user.getUid());
        ViewPointService viewPointService=EasyMock.createMock(ViewPointService.class);

        ViewPointExample example = new ViewPointExample();
        //增加条件
        ViewPointExample.Criteria criteria = example.createCriteria();
        criteria.andTpVtypeEqualTo(like);
        criteria.andTpVcityEqualTo(desCity);
        //example.setOrderByClause("desc");
        List<ViewPoint> list1=new ArrayList<ViewPoint>();
        ViewPoint viewPoint=new ViewPoint();
        viewPoint.setTpVid(1);
        viewPoint.setTpVname("杭州动物园");
        ViewPoint viewPoint2=new ViewPoint();
        viewPoint2.setTpVid(2);
        viewPoint2.setTpVname("杭州乐园");
        list1.add(viewPoint);
        list1.add(viewPoint2);
        EasyMock.expect(viewPointService.selectByExample(example)).andReturn(list1);
        EasyMock.replay(viewPointService);
        List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
        for(int i=0;i<2;i++)
            assertEquals(list1.get(i),viewPoints.get(i));
        EasyMock.verify(userService);
        EasyMock.verify(viewPointService);
    }


    @Test
    public void nearestHotels() {
        String City = "杭州";
        double[] lon1= {100,105,120,115};
        double[] lat1={90.5,91.4,89.3,91};
        HotelDao hotelDao=EasyMock.createMock(HotelDao.class);
        HotelExample example = new HotelExample();
        example.createCriteria().andCityEqualTo(City);
        example.setOrderByClause("hid desc");

        Hotel hotel1=new Hotel();
        hotel1.setLongitude("100");
        hotel1.setLatitude("90");
        Hotel hotel2=new Hotel();
        hotel2.setLongitude("101.5");
        hotel2.setLatitude("90");
        Hotel hotel3=new Hotel();
        hotel3.setLongitude("101");
        hotel3.setLatitude("89");
        Hotel hotel4=new Hotel();
        hotel4.setLongitude("103");
        hotel4.setLatitude("92");
        List<Hotel> list=new ArrayList<Hotel>();
        list.add(hotel1);
        list.add(hotel2);
        list.add(hotel3);
        list.add(hotel4);
        EasyMock.expect(hotelDao.selectByExample(example)).andReturn(list);
        EasyMock.replay(hotelDao);
        List<Hotel> hotels = hotelDao.selectByExample(example);
        List<Hotel> results=new ArrayList<Hotel>();
        int []distance=new int[lon1.length];
        double lon2, lat2;
        int flag = 0, min = 0;
        int dis;
        for(int i=0;i<lon1.length;i++) {
            dis=Integer.MAX_VALUE;
            flag = 0; min = 0;
            for (Hotel j : hotels) {
                lon2 = Double.parseDouble(j.getLongitude());
                lat2 = Double.parseDouble(j.getLatitude());
                double len = MapDistance.getDistance(lon1[i], lat1[i], lon2, lat2);
                if (len < dis) {
                    dis = (int) len;
                    min = flag;
                }
                flag++;
            }
            if(hotels.get(min)!=null)
                results.add(hotels.get(min));
            distance[i]= dis;
        }

        assertEquals(results.get(0),hotels.get(0));
        assertEquals(results.get(1),hotels.get(3));
        assertEquals(results.get(2),hotels.get(2));
        assertEquals(results.get(3),list.get(0));
        assertEquals(distance[0],55659);
        assertEquals(distance[1],67107);
        assertEquals(distance[2],45391);
        assertEquals(distance[3],111319);
        EasyMock.verify(hotelDao);

    }
}