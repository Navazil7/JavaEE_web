package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.commons.TimeStampUtil;
import cn.zm.trip.web.dao.*;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.AdminService;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private ViewPointDao viewPointDao;
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private TrafficDao trafficDao;
	@Autowired
	private WordsDao wordsDao;
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private StationDao stationDao;

	/**
	 * **********login start***************
	 * 从前端跳转到后台登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * 登录逻辑
	 * handle
	 *
	 * @param aemail 用户邮箱
	 * @param apwd   密码
	 * @return String
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	// @RequestParam(required = true) 为true时意思为不可缺省
	public String login(String aemail, String apwd, HttpSession session) {
		Admin admin = adminService.login(aemail, apwd);
		String timestamp = TimeStampUtil.getTimeFormat();

		//登录失败
		if (admin == null) {
			session.setAttribute("msg", Msg.fail("邮箱或者密码错误!"));
			return login();
		}
		//登录成功
		else {

			// 将登录信息放入session
			session.setAttribute("msg", Msg.success());
			session.setAttribute("timestamp", timestamp);
			session.setAttribute("admin", admin);
			// 明日任务,获取域对象传送user信息
			return "redirect:main";
		}
	}

	/**
	 * 后台注销
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		//销毁session
		session.invalidate();
		return login();
	}
	//**********login end***************

	/**
	 * **********main start***************
	 * 登录成功后跳转管理主界面
	 *
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
	//**********main end***************


	/**********user start***************
	 * 查看用户列表
	 */
	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public String userList() {
		String prefix = "/static/upload/useravatar/";
		List<User> users = userService.selectAll();
		for (User user : users) {
			String suffix = user.getUpic();
			user.setUpic(prefix + suffix);
		}
		session.setAttribute("users", users);
		return "admin/user_list";
	}

	/**
	 * 用户模糊搜索
	 */
	@RequestMapping(value = "usersearch", method = RequestMethod.GET)
	public String userSearch(String keyword, HttpSession session) {
		System.out.println(keyword);
		String prefix = "/static/upload/useravatar/";
		List<User> users = userService.search(keyword);
		for (User user : users){
			String imgUrl = user.getUpic();
			user.setUpic(prefix + imgUrl);
		}
		session.setAttribute("users", users);
		session.setAttribute("msg", Msg.success("用户查询成功!"));

		return "admin/user_list";
	}

	/**
	 * 景点模糊搜索
	 */
	@RequestMapping(value = "viewPointSearch", method = RequestMethod.GET)
	public String viewPointSearch(String keyword, Model model) {
		String prefix = "/static/upload/viewavatar/";

		ViewPoint viewPoint = new ViewPoint();

		viewPoint.setTpVname(keyword);
		viewPoint.setTpVtype(keyword);
		viewPoint.setTpLocation(keyword);
		List<ViewPoint> viewPoints = viewPointDao.viewPointSearch(viewPoint);

		for (ViewPoint vp : viewPoints){
			String imgUrl = vp.getTpVpic();
			vp.setTpVpic(prefix + imgUrl);
		}

		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("msg", Msg.success("景点查询成功!"));

		return "admin/view_list";
	}

	/**
	 * 后台酒店模糊搜索
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

		return "admin/hotel_list";
	}

	/**
	 * 后台论坛模糊搜索
	 */
	@RequestMapping(value = "forumPointSearch", method = RequestMethod.GET)
	public String forumPointSearch(String keyword, Model model) {

		Forum forum = new Forum();

		forum.setTpTag(keyword);
		forum.setTpTitle(keyword);
		forum.setTpSubTitle(keyword);
		forum.setTpAuthor(keyword);

		List<Forum> forums = forumDao.forumPointSearch(forum);

		model.addAttribute("forums", forums);
		model.addAttribute("msg", Msg.success("论坛查询成功!"));

		return "admin/forum_list";
	}

	/**
	 * 后台评论模糊搜索
	 */
	@RequestMapping(value = "wordsPointSearch", method = RequestMethod.GET)
	public String wordsPointSearch(String keyword, Model model) {

		Words words = new Words();

		words.setTp_wname(keyword);
		words.setTp_wcontent(keyword);
		words.setTp_wdate(keyword);
		words.setTp_w_for_name(keyword);
		words.setTp_w_forumId(keyword);
		words.setTp_w_hotelId(keyword);
		words.setTp_w_viewpointId(keyword);

		List<Words> byWords = wordsDao.wordsPointSearch(words);

		model.addAttribute("byWords", byWords);
		model.addAttribute("msg", Msg.success("留言查询成功!"));

		return "admin/words_list";
	}

	/**
	 * 后台回复模糊搜索
	 */
	@RequestMapping(value = "replyPointSearch", method = RequestMethod.GET)
	public String replyPointSearch(String keyword, Model model) {

		Reply reply = new Reply();

		reply.setTp_rname(keyword);
		reply.setTp_rcontent(keyword);
		reply.setTp_rdate(keyword);
		reply.setTp_r_for_name(keyword);
		reply.setTp_r_for_reply(keyword);
		reply.setTp_r_for_words(keyword);
		reply.setTp_r_forumId(keyword);
		reply.setTp_r_hotelId(keyword);
		reply.setTp_r_viewpointId(keyword);

		List<Reply> replys = replyDao.replyPointSearch(reply);

		model.addAttribute("replys", replys);
		model.addAttribute("msg", Msg.success("回复查询成功!"));

		return "admin/reply_list";
	}

	/**
	 * 后台交通列表模糊搜索
	 */
	@RequestMapping(value = "trafficPointSearch", method = RequestMethod.GET)
	public String trafficPointSearch(String keyword, Model model) {

		Traffic traffic = new Traffic();

		traffic.setTpType(keyword);
		traffic.setTpCurrent(keyword);
		traffic.setTpDestination(keyword);

		List<Traffic> traffics = trafficDao.trafficPointSearch(traffic);

		model.addAttribute("traffics", traffics);
		model.addAttribute("msg", Msg.success("交通查询成功!"));

		return "admin/traffic_list";
	}

	/**
	 * 后台站点列表模糊搜索
	 */
	@RequestMapping(value = "stationPointSearch", method = RequestMethod.GET)
	public String stationPointSearch(String keyword, Model model) {

		Station station = new Station();

		station.setTpSname(keyword);
		station.setTpSlocal(keyword);
		station.setTpScity(keyword);

		List<Station> stations = stationDao.stationPointSearch(station);

		model.addAttribute("stations", stations);
		model.addAttribute("msg", Msg.success("站点查询成功!"));

		return "admin/station_list";
	}

	/**
	 * 用户单个单击删除
	 */
	@RequestMapping(value = "userdelete", method = RequestMethod.GET)
	public String userDelete(String uid) {
		System.out.println(uid);
		String prefix = "/static/upload/useravatar/";
		userService.userDelete(uid);
		List<User> users = userService.selectAll();
		for (User user : users){
			String imgUrl = user.getUpic();
			user.setUpic(prefix + imgUrl);
		}
		session.setAttribute("users", users);
		session.setAttribute("msg", Msg.success(uid + "号用户删除成功!"));
		return "admin/user_list";
	}

	/**
	 * 用户新增表单跳转
	 */
	@RequestMapping(value = "userform", method = RequestMethod.GET)
	public String userForm() {
		return "admin/user_form";
	}

	/**
	 * 用户新增
	 */
	@RequestMapping(value = "userinsert", method = RequestMethod.POST)
	public String userInsert(String uname, String uemail, String upwd) {
		userService.insertUser(uname, uemail, upwd);
		session.setAttribute("msg", Msg.success("新增用户成功"));
		return "redirect:userlist";
	}

	/**
	 * 用户批量删除功能
	 */
	@RequestMapping(value = "usersectiondelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String userSectionDelete(String[] uids) {
		for (String uid : uids) {
			userService.userDelete(uid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(uids) + "号用户批量删除成功!"));
		return "1";
	}

	/**
	 * 跳转用户编辑更新界面
	 */
	@RequestMapping(value = "useredit", method = RequestMethod.GET)
	public String userEdit(String uid) {
		User user = userService.userGet(uid);
		System.out.println(user);
		session.setAttribute("user", user);

		return "admin/user_edit";
	}

	/**
	 * 跳转用户更新业务
	 */
	@RequestMapping(value = "useredithandle", method = RequestMethod.POST)
	public String userEditHandle(User user) {
		userService.updataUserInfo(user);
		session.setAttribute("msg", Msg.success("用户信息保存成功!"));
		return "redirect:userlist";
	}
	//**********user start***************


	/************view start***************
	 * 跳转内容管理 景点列表
	 */
	@RequestMapping(value = "viewlist", method = RequestMethod.GET)
	public String viewPoint(ViewPointExample example, Model model, HttpServletRequest request) {
		example.setOrderByClause("tp_vid desc");
		String prefix = "/static/upload/viewavatar/";
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		for (ViewPoint viewPoint : viewPoints) {
			String suffix = viewPoint.getTpVpic();
			//前端img标签路径
			viewPoint.setTpVpic(prefix + suffix);
		}
		//存储信息转发
		model.addAttribute("viewPoints", viewPoints);
		return "admin/view_list";
	}

	/**
	 * 用户批量删除功能
	 */
	@RequestMapping(value = "viewsectiondelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String viewSectionDelete(Integer[] tpVids) {
		for (Integer tpVid : tpVids) {
			viewPointService.deleteviews(tpVid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpVids) + "号景点批量删除成功!"));
		return "1";
	}

	/**
	 * 景点查看
	 */
	@RequestMapping(value = "viewcontent", method = RequestMethod.GET)
	public String viewcontent(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		String prefix = "/static/upload/viewavatar/";
		String suffix = viewPoint.getTpVpic();
		//前端img标签路径
		viewPoint.setTpVpic(prefix + suffix);
		model.addAttribute("viewPoint", viewPoint);
		return "admin/view_content";
	}

	/**
	 * 用户单个单击删除
	 */
	@RequestMapping(value = "viewdelete", method = RequestMethod.GET)
	public String viewDelete(Integer tpVid) {
		viewPointService.deleteviews(tpVid);

		session.setAttribute("msg", Msg.success(tpVid + "号用户删除成功!"));
		return "redirect:viewlist";
	}

	/**
	 * 景点新增表单跳转
	 */
	@RequestMapping(value = "viewform", method = RequestMethod.GET)
	public String viewForm() {
		return "admin/view_form";
	}

	/**
	 * 景点新增
	 */
	@RequestMapping(value = "viewinsert", method = RequestMethod.POST)
	public String viewInsert(ViewPoint viewPoint) {
		if (viewPoint.getTpVid() == null) {
			viewPointService.insertView(viewPoint);
			session.setAttribute("msg", Msg.success("新增景点成功!"));
			return "redirect:viewlist";
		}
		session.setAttribute("msg", Msg.fail("新增景点失败!"));
		return "redirect:viewlist";
	}


	/**
	 * 跳转景点编辑更新界面
	 */
	@RequestMapping(value = "viewedit", method = RequestMethod.GET)
	public String viewEdit(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		model.addAttribute("viewPoint", viewPoint);
		return "admin/view_edit";
	}

	/**
	 * 跳转景点更新业务
	 */
	@RequestMapping(value = "viewedithandle", method = RequestMethod.POST)
	public String viewEditHandle(ViewPoint viewPoint) {
		viewPointService.updateByPrimaryKeySelective(viewPoint);
		session.setAttribute("msg", Msg.success("景点信息保存成功!"));
		return "redirect:viewlist";
	}

	//**********view end***************

	/*************hotel ************
	 * 跳转
	 * 酒店管理列表
	 */
	@RequestMapping(value = "hotellist", method = RequestMethod.GET)
	public String hotelList(Model model) {
		HotelExample example = new HotelExample();
		String prefix = "/static/upload/hotelAvatar/";

		example.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(example);
		for (Hotel hotel : hotels) {
			String suffix = hotel.getImgUrl();
			//前端img标签路径
			hotel.setImgUrl(prefix + suffix);
		}
		model.addAttribute("hotels", hotels);

		return "admin/hotel_list";
	}

	/**
	 * 跳转
	 * 酒店管理列表
	 */
	@RequestMapping(value = "hotelcontent", method = RequestMethod.GET)
	public String hotelContent(Integer hid, Model model) {

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);
		String prefix = "/static/upload/hotelAvatar/";
		String suffix = hotel.getImgUrl();
		//前端img标签路径
		hotel.setImgUrl(prefix + suffix);

		model.addAttribute("hotel", hotel);

		return "admin/hotel_content";
	}

	/**
	 * 跳转
	 * 酒店编辑
	 */
	@RequestMapping(value = "hoteledit", method = RequestMethod.GET)
	public String hotelEdit(Integer hid, Model model) {

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);

		model.addAttribute("hotel", hotel);
		return "admin/hotel_edit";
	}

	/**
	 * 跳转
	 * 站点编辑
	 */
	@RequestMapping(value = "stationedit", method = RequestMethod.GET)
	public String stationEdit(Integer tpSid, Model model) {

		Station station = stationDao.selectByPrimaryKey(tpSid);

		model.addAttribute("station", station);
		return "admin/station_edit";
	}

	/**
	 * 跳转站点更新业务
	 */
	@RequestMapping(value = "stationedithandle", method = RequestMethod.POST)
	public String stationedithandle(Station station) {
		stationDao.updateByPrimaryKeySelective(station);
		session.setAttribute("msg", Msg.success("站点信息保存成功!"));
		return "redirect:stationList";
	}

	/**
	 * 跳转景点更新业务
	 */
	@RequestMapping(value = "hoteledithandle", method = RequestMethod.POST)
	public String hotelEditHandle(Hotel hotel) {
		hotelDao.updateByPrimaryKeySelective(hotel);
		session.setAttribute("msg", Msg.success("酒店信息保存成功!"));
		return "redirect:hotellist";
	}

	/**
	 * 跳转景点更新业务
	 */
	@RequestMapping(value = "hoteldelete", method = RequestMethod.GET)
	public String hotelDelete(Integer hid) {
		hotelDao.deleteByPrimaryKey(hid);
		session.setAttribute("msg", Msg.success("删除酒店成功!"));
		return "redirect:hotellist";
	}

	/**
	 * 酒店
	 * 批量删除
	 */

	@RequestMapping(value = "hotelMutiDelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String hotelMutiDelete(Integer[] hids) {
		for (Integer hid : hids) {
			hotelDao.deleteByPrimaryKey(hid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(hids) + "号景点批量删除成功!"));
		return "1";
	}

	/**
	 * 酒店
	 * 新增表单跳转
	 */
	@RequestMapping(value = "hotelInsertForm", method = RequestMethod.GET)
	public String hotelInsertForm() {
		return "admin/hotel_insert";
	}

	/**
	 * 酒店新增
	 */
	@RequestMapping(value = "hotelInsert", method = RequestMethod.POST)
	public String hotelInsert(Hotel hotel, Model model) {
		if (hotel.getHid() == null) {
			hotelDao.insertSelective(hotel);
			model.addAttribute("msg", Msg.success("新增酒店成功!"));
			return "redirect:hotellist";
		}
		model.addAttribute("msg", Msg.fail("新增酒店失败!"));
		return "redirect:hoteledit";
	}

	/**
	 * 站店新增
	 */
	@RequestMapping(value = "stationInsert", method = RequestMethod.POST)
	public String stationInsert(Station station, Model model) {
		if (station.getTpSid() == null) {
			stationDao.insertSelective(station);
			model.addAttribute("msg", Msg.success("新增站点成功!"));
			return "redirect:stationList";
		}
		model.addAttribute("msg", Msg.fail("新增站点失败!"));
		return "redirect:stationedit";
	}

	/**
	 * content
	 */
	@RequestMapping(value = "forumList", method = RequestMethod.GET)
	public String forumList(Model model) {
		ForumExample example = new ForumExample();
		example.setOrderByClause("tp_fid desc");

		List<Forum> forums = forumDao.selectByExample(example);

		model.addAttribute("forums", forums);

		return "admin/forum_list";
	}

	/**
	 *
	 * @param tpFids
	 * @param model
	 * @return
	 */
	@ResponseBody//返回给前端
	@RequestMapping(value = "forumMutiDelete", method = RequestMethod.GET)
	public String forumMutiDelete(Integer[] tpFids, Model model) {
		for (Integer tpFid : tpFids) {
			forumDao.deleteByPrimaryKey(tpFid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpFids) + "号批量删除成功!"));
		return "1";
	}

	/**
	 * forummutidelete
	 */
	@RequestMapping(value = "forumDelete", method = RequestMethod.GET)
	public String forumDelete(Integer tpFid, Model model) {
		forumDao.deleteByPrimaryKey(tpFid);
		model.addAttribute("msg", Msg.success(tpFid + "号批量删除成功!"));
		return "redirect:forumList";
	}

	/**
	 * 酒店
	 * 新增表单跳转
	 */
	@RequestMapping(value = "forumInsertForm", method = RequestMethod.GET)
	public String forumInsertForm() {
		return "admin/forum_insert";
	}

	/**
	 * 酒店新增
	 */
	@RequestMapping(value = "forumInsert", method = RequestMethod.POST)
	public String forumInsert(Forum forum, Model model) {
		if (forum.getTpFid() == null) {
			forumDao.insert(forum);
			model.addAttribute("msg", Msg.success("新帖子成功!"));
			return "redirect:forumList";
		}
		model.addAttribute("msg", Msg.fail("新增帖子失败!"));
		return "redirect:forumList";
	}

	/**
	 * 酒店新增
	 */
	@RequestMapping(value = "forumEditForm", method = RequestMethod.GET)
	public String forumEditForm(Integer tpFid, Model model) {
		Forum forum = forumDao.selectByPrimaryKey(tpFid);
		model.addAttribute("forum", forum);
		return "admin/forum_edit";
	}

	/**
	 * 景点新增
	 */
	@RequestMapping(value = "forumEdit", method = RequestMethod.POST)
	public String forumEdit(Forum forum, Model model) {
		forumDao.updateByPrimaryKeySelective(forum);
		model.addAttribute("msg", Msg.success("更新成功!"));
		return "redirect:forumList";
	}

	/**Traffic**
	 * 跳转交通列表页面
	 */
	@RequestMapping(value = "trafficList", method = RequestMethod.GET)
	public String trafficList(Model model) {
		TrafficExample example = new TrafficExample();
		example.setOrderByClause("tp_Tid desc");
		List<Traffic> traffics = trafficDao.selectByExample(example);

		model.addAttribute("traffics", traffics);
		return "admin/traffic_list";
	}

	/**Station**
	 * 跳转站点列表页面
	 */
	@RequestMapping(value = "stationList", method = RequestMethod.GET)
	public String stationList(Model model) {
		StationExample example = new StationExample();
		example.setOrderByClause("tp_sid desc");
		List<Station> stations = stationDao.selectByExample(example);

		model.addAttribute("stations", stations);
		return "admin/station_list";
	}



	/**
	 * 跳转交通新增页面
	 * @return
	 */
	@RequestMapping(value = "trafficInsert", method = RequestMethod.GET)
	public String trafficInsert() {
		return "admin/traffic_insert";
	}

	/**
	 * 跳转站点新增页面
	 * @return
	 */
	@RequestMapping(value = "stationInsert", method = RequestMethod.GET)
	public String stationInsert() {
		return "admin/station_insert";
	}

	/**
	 * 提交新增信息
	 * @return
	 */
	@RequestMapping(value = "trafficInsertHandler", method = RequestMethod.POST)
	public String trafficInsertHandler(Traffic traffic, String currentTime, String arriveTime, Model model) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// String parseCurrent = simpleDateFormat.format(currentTime);
			// String parseArriveTime = simpleDateFormat.format(arriveTime);
			traffic.setTpCurrentTime(currentTime);
			traffic.setTpArriveTime(arriveTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		trafficDao.insertSelective(traffic);
		model.addAttribute("msg",Msg.success("新增交通信息成功！"));
		return "redirect:trafficList";
	}

	/**
	 * 单机删除
	 * @return
	 */
	@RequestMapping(value = "trafficDelete", method = RequestMethod.GET)
	public String trafficDelete(Integer tpTid, Model model) {
		trafficDao.deleteByPrimaryKey(tpTid);
		model.addAttribute("msg", Msg.success(tpTid + "号删除成功！"));
		return "redirect:trafficList";
	}
	/**
	 * 批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "trafficMutiDelete", method = RequestMethod.GET)
	public String trafficsMutiDelete(Integer[] tpTids, Model model) {

		for (Integer tpTid : tpTids){
			trafficDao.deleteByPrimaryKey(tpTid);

		}
		model.addAttribute("msg", Msg.success(Arrays.toString(tpTids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 单机删除
	 * @return
	 */
	@RequestMapping(value = "stationDelete", method = RequestMethod.GET)
	public String stationDelete(Integer tpSid, Model model) {
		stationDao.deleteByPrimaryKey(tpSid);
		model.addAttribute("msg", Msg.success(tpSid + "号删除成功！"));
		return "redirect:stationList";
	}
	/**
	 * 批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "stationMutiDelete", method = RequestMethod.GET)
	public String stationsMutiDelete(Integer[] tpSids, Model model) {

		for (Integer tpSid : tpSids){
			stationDao.deleteByPrimaryKey(tpSid);

		}
		model.addAttribute("msg", Msg.success(Arrays.toString(tpSids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 跳转交通编辑页面
	 * @return String
	 */
	@RequestMapping(value = "trafficEdit", method = RequestMethod.GET)
	public String trafficEdit(Integer tpTid, Model model) {
		Traffic traffic = trafficDao.selectByPrimaryKey(tpTid);

		model.addAttribute("traffic", traffic);
		return "admin/traffic_edit";
	}

	/**
	 * 交通编辑
	 * @return
	 */
	@RequestMapping(value = "trafficEditHandle", method = RequestMethod.POST)
	public String trafficEditHandle(Traffic traffic, String currentTime, String arriveTime, Model model) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// String parseCurrent = simpleDateFormat.format(currentTime);
			// String parseArriveTime = simpleDateFormat.format(arriveTime);
			traffic.setTpCurrentTime(currentTime);
			traffic.setTpArriveTime(arriveTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		trafficDao.updateByPrimaryKeySelective(traffic);
		model.addAttribute("msg",Msg.success("更新成功！"));
		return "redirect:trafficList";
	}


	/**
	 * 跳转评论列表
	 * @return
	 */
	@RequestMapping(value = "wordsList", method = RequestMethod.GET)
	public String wordsList(Model model) {
		List<Words> byWords = viewPointService.findByWords();
		model.addAttribute("byWords", byWords);
		return "admin/words_list";
	}

	/**
	 * 留言批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "wordsMutiDelete", method = RequestMethod.GET)
	public String wordsMutiDelete(Integer[] tp_wids, Model model) {

		for (Integer tp_wid : tp_wids){
			wordsDao.deleteByPrimaryKey(tp_wid);

		}
		model.addAttribute("msg", Msg.success(Arrays.toString(tp_wids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 单击删除
	 * @return
	 */
	@RequestMapping(value = "wordsDelete", method = RequestMethod.GET)
	public String wordsDelete(Integer tp_wid, Model model) {
		wordsDao.deleteByPrimaryKey(tp_wid);
		model.addAttribute("msg", Msg.success(tp_wid + "号删除成功！"));
		return "redirect:wordsList";
	}

	/**
	 * 跳转回复列表
	 * @return
	 */
	@RequestMapping(value = "replyList", method = RequestMethod.GET)
	public String ReplyList(Model model) {
		List<Reply> replys = viewPointService.findByReply();
		model.addAttribute("replys", replys);
		return "admin/reply_list";
	}

	/**
	 * 回复批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "replyMutiDelete", method = RequestMethod.GET)
	public String replyMutiDelete(Integer[] tp_rids, Model model) {
		for (Integer tp_rid : tp_rids){
			replyDao.deleteByPrimaryKey(tp_rid);

		}
		model.addAttribute("msg", Msg.success(Arrays.toString(tp_rids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 单击删除
	 * @return
	 */
	@RequestMapping(value = "replyDelete", method = RequestMethod.GET)
	public String replyDelete(Integer tp_rid, Model model) {
		replyDao.deleteByPrimaryKey(tp_rid);
		model.addAttribute("msg", Msg.success(tp_rid + "号删除成功！"));
		return "redirect:replyList";
	}

}