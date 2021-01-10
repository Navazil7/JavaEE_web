package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.MapDistance;
import cn.zm.trip.web.commons.ajaxcustData;
import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.OrderService;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "cust")
public class CustController {
	@Autowired
	TrafficDao trafficDao;
	@Autowired
	ViewPointDao viewPointDao;
	@Autowired
	HotelDao hotelDao;
	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ViewPointService viewPointService;
	/**
	 * 跳转定制
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "proscenium/cust/index";
	}

	/**
	 * 定制返回景
	 */
	@ResponseBody
	@RequestMapping(value = "viewPoint", method = RequestMethod.GET)
	public List<ViewPoint> viewPoint(String tpLocation) {
		// 规范城市名
		tpLocation=tpLocation.substring(0,2);

		ViewPointExample example = new ViewPointExample();
		example.createCriteria().andTpVcityEqualTo(tpLocation);
		example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		return viewPoints;
	}
	/**
	 * 定制返回景点到购物车
	 */
	@RequestMapping(value = "viewPointCart", method = RequestMethod.POST)
	@ResponseBody
	public List<ViewPoint> viewPointCart(int[] views) {
		List<ViewPoint> viewPoints = new ArrayList<ViewPoint>();
		for(int i:views){
			ViewPoint	viewpoint=viewPointService.selectByPrimaryKey(i);
			viewPoints.add(viewpoint);
		}
		return viewPoints;
	}
	/**
	 * 一键定制返回景点到购物车
	 */
	@RequestMapping(value = "viewPointCartAuto", method = RequestMethod.POST)
	@ResponseBody
	public List<ViewPoint> viewPointCartAtuo(String desCity) {
		// 规范城市名
		desCity=desCity.substring(0,2);
		User user = (User)session.getAttribute("user");
		String like = userService.userLikeVtype(user.getUid());

		ViewPointExample example = new ViewPointExample();

		//增加条件
		ViewPointExample.Criteria criteria = example.createCriteria();
		criteria.andTpVtypeEqualTo(like);
		criteria.andTpVcityEqualTo(desCity);
		//example.setOrderByClause("desc");

		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		return viewPoints;
	}
	/**
	 * 定制返回酒店 以city列
	 */
	@ResponseBody
	@RequestMapping(value = "hotel", method = RequestMethod.GET)
	public List<Hotel> hotel(String local) {
		// 规范城市名
		local=local.substring(0,2);

		String filePath = "/static/upload/hotelAvatar/";
		HotelExample example = new HotelExample();
		example.createCriteria().andCityEqualTo(local);
		example.setOrderByClause("hid desc");
		System.out.println(example);
		List<Hotel> hotels = hotelDao.selectByExample(example);
		for (Hotel hotel : hotels){
			String fileSuffix = hotel.getImgUrl();
			hotel.setImgUrl(filePath + fileSuffix);
		}
		System.out.println(hotels);
		return hotels;
	}
	@RequestMapping(value = "NearestHotels", method = RequestMethod.POST)
	@ResponseBody
	public ajaxcustData NearestHotels(String[] lon, String[] lat,  String City,  Model model) {
		City = City.substring(0,2);
		double[] lon1=new double[lat.length];
		double[] lat1=new double[lon.length];
		for(int i=0;i<lon.length;i++){
			lon1[i]= Double.parseDouble(lon[i]);
			lat1[i]= Double.parseDouble(lat[i]);
		}
		HotelExample example = new HotelExample();
		example.createCriteria().andCityEqualTo(City);
		example.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(example);
		List<Hotel> results=new ArrayList<Hotel>();
		//List<Integer> distance=new ArrayList<Integer>();
		int []distance=new int[lon.length];
		double lon2, lat2;
		int flag = 0, min = 0;
		int dis;
		for(int i=0;i<lon.length;i++) {
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

			System.out.println(dis);
			if(hotels.get(min)!=null)
				results.add(hotels.get(min));
			distance[i]= dis;
			String tmp="distance"+i;

		}
		ajaxcustData acd=new ajaxcustData();
		acd.setDistance(distance);
		acd.setResults(results);
		session.setAttribute("distance", distance);
		return acd;
	}
	@RequestMapping(value = "hotels", method = RequestMethod.POST)
	@ResponseBody
	public List<Hotel> hotels(int[] hotels_id) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		for (int i: hotels_id){
			Hotel h=hotelDao.selectByPrimaryKey(i);
			hotels.add(h);
		}
		return hotels;
	}
	@RequestMapping(value = "HandleOrder", method = RequestMethod.POST)
	@ResponseBody
	public String HandleOrder(String[] IDs,String[] Num,String[] Type,String totalPrice) {
		//调用订单接口 Type区分订单类型 IDs为该类型的id值 totalPrice订单总价 Num为每项订单的数量
		System.out.println("处理开始");
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date_time=df.format(d);
		String date=date_time.split(" ")[0].trim();
		String time=date_time.split(" ")[1].trim();
		String[] date_array=date.split("-");
		String[] time_array=time.split(":");
		String dt=date_array[0]+(date_array[1].length()<2? "0"+date_array[1]:date_array[1])+(date_array[2].length()<2? "0"+date_array[2]:date_array[2])+(time_array[0].length()<2? "0"+time_array[0]:time_array[0])+(time_array[1].length()<2? "0"+time_array[1]:time_array[1])+(time_array[2].length()<2? "0"+time_array[2]:time_array[2]);
//		System.out.println(dt);
		String tpUid=((User)session.getAttribute("user")).getUid();
		User user=userService.findUser(tpUid);
//		System.out.println(Type.length);
		if(Type!=null)
			for(int i=0;i<Type.length;i++)
				if(user!=null){
					System.out.println(i);
					if("景点".equals(Type[i])){ // 景点订单
						ViewPoint viewPoint=viewPointDao.selectByPrimaryKey(Integer.parseInt(IDs[i]));
						String oid="A"+dt+user.getPhone().trim().substring(9)+viewPoint.getTpVid();
						AttractionOrder attractionOrder=new AttractionOrder();
						attractionOrder.setAttr_orderId(oid);
						attractionOrder.setAttr_uid(Integer.parseInt(tpUid));
						attractionOrder.setAttr_cost(Integer.parseInt(Num[i])*Integer.parseInt(viewPoint.getTpPrice()));
						attractionOrder.setAttr_createDate(date);
						attractionOrder.setAttr_createTime(time);
						attractionOrder.setAttr_name(viewPoint.getTpVname());
						attractionOrder.setAttr_place(viewPoint.getTpLocation());
						attractionOrder.setAttr_uemail(user.getUemail());
						attractionOrder.setAttr_uphone(user.getPhone());
						attractionOrder.setAttr_vid(viewPoint.getTpVid());


						String orderInfo=attractionOrder.getAttr_name().trim()+"#"+attractionOrder.getAttr_place().trim()+"#"+attractionOrder.getAttr_uemail().trim()+"#"
								+attractionOrder.getAttr_uphone().trim()+"#"+attractionOrder.getAttr_cost()+"#"+attractionOrder.getAttr_createDate().trim()+"#"
								+attractionOrder.getAttr_createTime().trim()+"#"+"任意时间"+"#"+attractionOrder.getAttr_vid().toString();
						orderService.insertOrder(attractionOrder.getAttr_orderId().trim(),attractionOrder.getAttr_uid(),orderInfo,"未使用");
						System.out.println("111");
					}
					else if("住宿".equals(Type[i])){ //酒店订单
						Hotel hotel=hotelDao.selectByPrimaryKey(Integer.parseInt(IDs[i]));
						String oid="H"+dt+user.getPhone().trim().substring(9)+hotel.getHid();
						HotelOrder hotelorder=new HotelOrder();
						hotelorder.setHotel_orderId(oid);
						hotelorder.setHotel_uid(Integer.parseInt(tpUid));
						hotelorder.setHotel_cost(Integer.parseInt(Num[i])*Integer.parseInt(hotel.getPrice()));
						hotelorder.setHotel_createDate(date);
						hotelorder.setHotel_createTime(time);
						hotelorder.setHotel_name(hotel.getTitle());
						hotelorder.setHotel_place(hotel.getLocal());
						hotelorder.setHotel_uemail(user.getUemail());
						hotelorder.setHotel_uphone(user.getPhone());
						hotelorder.setHotel_hid(hotel.getHid());

						String orderInfo=hotelorder.getHotel_name().trim()+"#"+hotelorder.getHotel_place().trim()+"#"+hotelorder.getHotel_uemail().trim()+"#"
								+hotelorder.getHotel_uphone().trim()+"#"+hotelorder.getHotel_cost()+"#"+hotelorder.getHotel_createDate().trim()+"#"
								+hotelorder.getHotel_createTime().trim()+"#"+"任意时间"+"#"+hotelorder.getHotel_hid().toString()+"#"+Num[i];
						orderService.insertOrder(hotelorder.getHotel_orderId(),hotelorder.getHotel_uid(),orderInfo,"未使用");
						System.out.println("1112");
					}
					else{
						Traffic traffic=trafficDao.selectByPrimaryKey(Integer.parseInt(IDs[i]));
						String oid="H"+dt+user.getPhone().trim().substring(7);
						TrafficOrder trafficorder=new TrafficOrder();
						trafficorder.setTraffic_orderId(oid);
						trafficorder.setTraffic_uid(Integer.parseInt(tpUid));
						trafficorder.setTraffic_cost(Integer.parseInt(IDs[i])*Integer.parseInt(Num[i]));
						trafficorder.setTraffic_createDate(date);
						trafficorder.setTraffic_createTime(time);
						trafficorder.setTraffic_depart(traffic.getTpCurrent());
						String at[]=traffic.getTpArriveTime().split(" ");
						trafficorder.setTraffic_departDate(at[0]);
						trafficorder.setTraffic_departTime(at[1]);
						trafficorder.setTraffic_des(traffic.getTpDestination());
						trafficorder.setTraffic_type(traffic.getTpType());
						trafficorder.setTraffic_uemail(user.getUemail());
						trafficorder.setTraffic_uphone(user.getPhone());
						trafficorder.setTraffic_tid(traffic.getTpTid());
						String dtime[]=traffic.getTpArriveTime().split(" ");
						trafficorder.setTraffic_desDate(dtime[0]);
						trafficorder.setTraffic_desTime(dtime[1]);
						String orderInfo=trafficorder.getTraffic_type().trim()+"#"+trafficorder.getTraffic_uemail().trim()+"#"
								+trafficorder.getTraffic_uphone().trim()+"#"+trafficorder.getTraffic_depart()+"#"+trafficorder.getTraffic_des().trim()+"#"
								+trafficorder.getTraffic_departDate().trim()+"#"+trafficorder.getTraffic_departTime().trim()+"#"+trafficorder.getTraffic_desDate()+"#"+trafficorder.getTraffic_desTime()
								+"#"+trafficorder.getTraffic_cost()+"#"+trafficorder.getTraffic_createDate()+"#"+trafficorder.getTraffic_createTime()+"#"+Num[i];
						orderService.insertOrder(trafficorder.getTraffic_orderId(),trafficorder.getTraffic_uid(),orderInfo,"未使用");
						System.out.println("1113");
					}

				}
				else{ //用户未登录
					return "redirect:/index";
				}
		return "redirect:/user/info?uid="+tpUid;
	}
}
