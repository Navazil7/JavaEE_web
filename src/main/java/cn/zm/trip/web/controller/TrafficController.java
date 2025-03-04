package cn.zm.trip.web.controller;

import cn.zm.trip.web.dao.StationDao;
import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.domain.Station;
import cn.zm.trip.web.domain.StationExample;
import cn.zm.trip.web.domain.Traffic;
import cn.zm.trip.web.domain.TrafficExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "traffic")
public class TrafficController {
	@Autowired
	TrafficDao trafficDao;
	@Autowired
	StationDao stationDao;

	public TrafficDao getTrafficDao() {
		return trafficDao;
	}

	public void setTrafficDao(TrafficDao trafficDao) {
		this.trafficDao = trafficDao;
	}

	public StationDao getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}

	/**
	 *
	 * @param currentCity
	 * @param desCity
	 * @return
	 */
	@RequestMapping(value = "selectByCurrentAndDestination", method = RequestMethod.GET)
	@ResponseBody
	public List<Traffic> traffic(String currentCity, String desCity,String traffic_type) {

		//规范城市名
		currentCity=currentCity.substring(0,2);
		desCity=desCity.substring(0,2);
		//根据城市找站点 再根据站点找票
		TrafficExample example = new TrafficExample();
		List<Traffic> traffics = trafficDao.selectByExample(example);
		StationExample example1 = new StationExample();
		List<Station> stations = stationDao.selectByExample(example1);

		// 找出符合城市要求的station
		List<Station> stations1=new ArrayList<>();//出发地城市所有站点
		List<Station> stations2=new ArrayList<>();//目的地城市所有站点
		for(Station station:stations){
			if(station.getTpScity().equals(currentCity)){
				stations1.add(station);
			}
			if(station.getTpScity().equals(desCity)){
				stations2.add(station);
			}
		}

		List<Traffic> queryTraffics = new ArrayList<>();
		for(Traffic traffic : traffics) {
			// 出发时间当然要比现在迟
			try {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date nowTime = new Date(System.currentTimeMillis());
				Date currentTime=sdf.parse(traffic.getTpCurrentTime());
				if(nowTime.after(currentTime)){
					continue;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			//任意交通工具
			if (traffic_type.equals("ALL")) {

				// 匹配traffic的出发站和终点站是否符合要求
				boolean flag1=false;
				for(Station station:stations1){
					if(traffic.getTpCurrent().equals(station.getTpSname())){
						flag1=true;break;
					}
				}
				if(flag1){
					for(Station station:stations2){
						if(traffic.getTpDestination().equals(station.getTpSname())){
							queryTraffics.add(traffic);break;
						}
					}
				}
			} else {
				//符合需要的交通工具
				if(traffic.getTpType().equals(traffic_type)){
					// 匹配traffic的出发站和终点站是否符合要求
					boolean flag1=false;
					for(Station station:stations1){
						if(traffic.getTpCurrent().equals(station.getTpSname())){
							flag1=true;break;
						}
					}
					if(flag1){
						for(Station station:stations2){
							if(traffic.getTpDestination().equals(station.getTpSname())){
								queryTraffics.add(traffic);break;
							}
						}
					}
				}
			}
		}

		return queryTraffics;
	}

	@RequestMapping(value = "selectTrafficByid", method = RequestMethod.GET)
	@ResponseBody
	public List<Traffic> trafficbyid(int traffic_id,Model model) {
		System.out.println("----------------"+traffic_id);
		Traffic traffic = trafficDao.selectByPrimaryKey(traffic_id);
		List<Traffic> queryTraffics = new ArrayList<>();
		queryTraffics.add(traffic);
		System.out.println("-----------------"+traffic.getTpTid());
		return queryTraffics;
	}
}
