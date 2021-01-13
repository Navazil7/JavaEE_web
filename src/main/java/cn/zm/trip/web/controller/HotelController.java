package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.ViewPointService;
import cn.zm.trip.web.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "hotel")
public class HotelController {
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private WordService wordService;


	/**
	 * 跳转首页
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		//实例化hotel examle
		HotelExample example = new HotelExample();
		example.setOrderByClause("hid desc");
		String prefix = "/static/upload/hotelAvatar/";
		List<Hotel> hotels = hotelDao.selectByExample(example);
		for (Hotel hotel : hotels) {
			//图片名
			String suffix = hotel.getImgUrl();
			//全路径
			hotel.setImgUrl(prefix + suffix);
		}
		//传送景点
		model.addAttribute("hotels", hotels);
		return "proscenium/hotel/index";
	}

	/**
	 * 跳转酒店介绍
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String content(Integer hid, Model model) {

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);
		if(hotel==null){
			return "error/product_off";
		}
		//封装留言信息
		List<Words> lw_list = wordService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		List<Reply> lr_list = wordService.findByReply();
		model.addAttribute("lr_list",lr_list);


		String prefix = "/static/upload/hotelAvatar/";
		//图片名
		String suffix = hotel.getImgUrl();
		//全路径
		hotel.setImgUrl(prefix + suffix);

		model.addAttribute("hotel", hotel);
		return "proscenium/hotel/content";
	}

	/**
	 * 用户酒店模糊搜索
	 */
	@RequestMapping(value = "hotelPointSearch", method = RequestMethod.GET)
	public String hotelPointSearch(String keyword, Model model) {
		String prefix = "/static/upload/hotelAvatar/";

		Hotel hotel = new Hotel();

		hotel.setLocal(keyword);
		hotel.setHouseType(keyword);
		hotel.setBedType(keyword);

		List<Hotel> hotels = hotelDao.hotelPointSearch(hotel);

		for (Hotel hotelForEach : hotels){
			String imgUrl = hotelForEach.getImgUrl();
			hotelForEach.setImgUrl(prefix + imgUrl);
		}

		model.addAttribute("hotels", hotels);
		model.addAttribute("msg", Msg.success("酒店查询成功!"));

		return "proscenium/hotel/index";
	}


}
