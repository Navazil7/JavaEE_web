package cn.zm.trip.web.controller;

import cn.zm.trip.web.dao.ForumDao;
import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class IndexController {
	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;

	/**
	 * 跳转首页
	 */
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ViewPointExample example, Model model) {
		HotelExample hotelExample = new HotelExample();
		ForumExample forumExample = new ForumExample();

		//显示首页的景点
		String prefix = "/static/upload/viewavatar/";
		//酒店
		String prefixHotel = "/static/upload/hotelAvatar/";

		//景点
		// 智能化推荐首页
		User user = (User)session.getAttribute("user");
		if(user!=null){
			String uid=user.getUid();
			String vtype=userService.userLikeVtype(uid);
			example.setOrderByClause("field(tp_vtype,'"+ vtype +"') desc");
		}
		else{
			example.setOrderByClause("tp_vid desc");
		}
		//example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		for (ViewPoint viewPoint : viewPoints) {
			String suffix = viewPoint.getTpVpic();
			viewPoint.setTpVpic(prefix + suffix);
		}
		//酒店
		hotelExample.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(hotelExample);
		for (Hotel hotel : hotels) {
			String suffix = hotel.getImgUrl();
			hotel.setImgUrl(prefixHotel + suffix);
		}

		List<Forum> forums = forumDao.selectByExample(forumExample);

		//传送景点
		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("hotels", hotels);
		model.addAttribute("forums", forums);

		return "index";
	}

}
