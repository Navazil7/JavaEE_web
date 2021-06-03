package cn.zm.trip.web.test;
import static org.easymock.EasyMock.*;

import cn.zm.trip.web.controller.TrafficController;
import cn.zm.trip.web.dao.StationDao;
import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.domain.Station;
import cn.zm.trip.web.domain.StationExample;
import cn.zm.trip.web.domain.Traffic;
import cn.zm.trip.web.domain.TrafficExample;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class TrafficControllerTest {
    TrafficController trafficController=new TrafficController();
    TrafficDao trafficDao;
    StationDao stationDao;
    @Before
    public void setUp() throws Exception {
        trafficDao=createMock(TrafficDao.class);
        stationDao=createMock(StationDao.class);

    }

    @After
    public void tearDown() throws Exception {
    }
    //飞机交通工具 只显示比当前时间晚的信息
    @Test
    public void traffic() {
        String currentCity="杭州";
        String desCity="北京";
        String  trafic="飞机";
        ArrayList<Traffic> traffics_list=new ArrayList<Traffic>();
        ArrayList<Station> stations_list=new ArrayList<Station>() ;
        Traffic traffic1=new Traffic();
        traffic1.setTpTid(1);
        traffic1.setTpCurrent(currentCity);
        traffic1.setTpDestination(desCity);
        traffic1.setTpCurrentTime("2020-10-01 09:00:00");
        traffic1.setTpArriveTime("2020-10-01 14:00:00");
        traffic1.setTpType("飞机");
        traffics_list.add(traffic1);

        Traffic traffic2=new Traffic();
        traffic2.setTpTid(2);
        traffic2.setTpCurrent(currentCity);
        traffic2.setTpDestination(desCity);
        traffic2.setTpCurrentTime("2021-10-01 09:00:00");
        traffic2.setTpArriveTime("2021-10-01 14:00:00");
        traffic2.setTpType("飞机");
        traffics_list.add(traffic2);

        Traffic traffic3=new Traffic();
        traffic3.setTpTid(3);
        traffic3.setTpCurrent(currentCity);
        traffic3.setTpDestination("上海");
        traffic3.setTpCurrentTime("2021-10-01 09:00:00");
        traffic3.setTpArriveTime("2021-10-01 14:00:00");
        traffic3.setTpType("飞机");
        traffics_list.add(traffic3);

        Traffic traffic4=new Traffic();
        traffic4.setTpTid(4);
        traffic4.setTpCurrent(currentCity);
        traffic4.setTpDestination(desCity);
        traffic4.setTpCurrentTime("2021-10-01 09:00:00");
        traffic4.setTpArriveTime("2021-10-01 14:00:00");
        traffic4.setTpType("火车");
        traffics_list.add(traffic4);

        Traffic traffic5=new Traffic();
        traffic5.setTpTid(5);
        traffic5.setTpCurrent("苏州");
        traffic5.setTpDestination(desCity);
        traffic5.setTpCurrentTime("2021-10-01 09:00:00");
        traffic5.setTpArriveTime("2021-10-01 14:00:00");
        traffic5.setTpType("飞机");
        traffics_list.add(traffic5);

        Station station1=new Station();
        station1.setTpSid(1);
        station1.setTpScity(currentCity);
        station1.setTpSname(currentCity);
        Station station2=new Station();
        station2.setTpSid(2);
        station2.setTpScity(desCity);
        station2.setTpSname(desCity);
        stations_list.add(station1);
        stations_list.add(station2);

        TrafficExample example = new TrafficExample();
        expect(trafficDao.selectByExample(example)).andReturn(traffics_list);
        EasyMock.replay(trafficDao);
        StationExample example1 = new StationExample();
        expect(stationDao.selectByExample(example1)).andReturn(stations_list);
        EasyMock.replay(stationDao);

        TrafficController trafficController = new TrafficController();
        trafficController.setStationDao(stationDao);
        trafficController.setTrafficDao(trafficDao);

        List<Traffic> queryTraffics;
        queryTraffics = trafficController.traffic(currentCity,desCity,trafic);
        assertEquals(traffic2, queryTraffics.get(0));


    }
    //ALL
    @Test
    public void traffic2() {
        String currentCity="杭州";
        String desCity="北京";
        String trafic="ALL";
        ArrayList<Traffic> traffics_list=new ArrayList<Traffic>();
        ArrayList<Station> stations_list=new ArrayList<Station>() ;

        Traffic traffic2=new Traffic();
        traffic2.setTpTid(2);
        traffic2.setTpCurrent(currentCity);
        traffic2.setTpDestination(desCity);
        traffic2.setTpCurrentTime("2021-10-01 09:00:00");
        traffic2.setTpArriveTime("2021-10-01 14:00:00");
        traffics_list.add(traffic2);

        Station station1=new Station();
        station1.setTpSid(1);
        station1.setTpScity(currentCity);
        station1.setTpSname(currentCity);
        Station station2=new Station();
        station2.setTpSid(2);
        station2.setTpScity(desCity);
        station2.setTpSname(desCity);
        stations_list.add(station1);
        stations_list.add(station2);

        TrafficExample example = new TrafficExample();
        expect(trafficDao.selectByExample(example)).andReturn(traffics_list);
        EasyMock.replay(trafficDao);
        StationExample example1 = new StationExample();
        expect(stationDao.selectByExample(example1)).andReturn(stations_list);
        EasyMock.replay(stationDao);

        TrafficController trafficController = new TrafficController();
        trafficController.setStationDao(stationDao);
        trafficController.setTrafficDao(trafficDao);

        List<Traffic> queryTraffics;
        queryTraffics = trafficController.traffic(currentCity,desCity,trafic);
        assertEquals(traffic2, queryTraffics.get(0));

    }

}