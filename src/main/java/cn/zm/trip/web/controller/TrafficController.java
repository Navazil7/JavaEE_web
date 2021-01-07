package cn.zm.trip.web.controller;

import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.domain.Traffic;
import cn.zm.trip.web.domain.TrafficExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "traffic")
public class TrafficController {
	@Autowired
	TrafficDao trafficDao;

	/**
	 *
	 * @param currentCity
	 * @param desCity
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "selectByCurrentAndDestination", method = RequestMethod.GET)
	@ResponseBody
	public List<Traffic> traffic(String currentCity, String desCity,String trafic,Model model) {
		TrafficExample example = new TrafficExample();
		List<Traffic> traffics = trafficDao.selectByExample(example);

		List<Traffic> queryTraffics = new ArrayList<>();

		for(Traffic traffic : traffics) {
			if (trafic.equals("ALL")) {
				if (currentCity.equals(traffic.getTpCurrent()) && desCity.equals(traffic.getTpDestination())) {
					queryTraffics.add(traffic);
				}
			} else {
				if (currentCity.equals(traffic.getTpCurrent()) && desCity.equals(traffic.getTpDestination()) && traffic.getTpType().equals(trafic)) {
					queryTraffics.add(traffic);
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
