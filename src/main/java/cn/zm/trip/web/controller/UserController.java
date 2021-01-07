package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.dao.CityDao;
import cn.zm.trip.web.dao.ForumDao;
import cn.zm.trip.web.dao.UserDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.event.EmailEvent;
import cn.zm.trip.web.event.EventPublisher;
import cn.zm.trip.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ForumExample example;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	EventPublisher eventPublisher;

	/**
	 * index页用户登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String userLogin(String uemail, String upwd, Model model) {

		//index页面登录成功图片显示路径
		String prefix = "/static/upload/useravatar/";
		//index页用户登录验证
		if (uemail == null || uemail == "" || upwd == null || upwd == "") {
			session.setAttribute("msg", Msg.fail("邮箱或密码不可为空!"));
			return "redirect:/index";
		}
		User user = userService.userLogin(new User(uemail, upwd));
		if (user != null) {
			String suffix = user.getUpic();
			user.setUpic(prefix+suffix);
			session.setAttribute("user", user);
			return "redirect:/index";
		} else {
			session.setAttribute("msg", Msg.fail("还未注册或邮箱密码错误,请重新输入!"));
			return "redirect:/index";
		}

	}

	/**
	 * 前台用户注销
	 *
	 * @return
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut() {
		session.invalidate();
		return "redirect:/index";
	}

	/**
	 * 跳转首页
	 *
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "redirect:/index";
	}
	/**
	 * 跳转注册用户
	 *
	 * @return
	 */
	@RequestMapping(value = "regst", method = RequestMethod.GET)
	public String regst() {
		return "proscenium/user/regst";
	}

	@RequestMapping(value = "regstform", method = RequestMethod.POST)
	public String regst(String uname, String uemail, String upwd, String reupwd, Model model) throws AWTException {
		if (uemail == null || upwd == null || uemail.trim().equals("") || upwd.trim().equals("")) {
			model.addAttribute("msg", Msg.fail("用户名或密码不可为空,请重新输入!"));
		} else if (!reupwd.equals(upwd)) {
			model.addAttribute("msg", Msg.fail("密码不正确请重新输入!"));
		} else {
			userService.insertUser(uname, uemail, upwd);
			model.addAttribute("msg", Msg.success("用户注册成功!"));

			//注册成功发送邮件
			EmailEvent emailEvent=new EmailEvent(this,uemail,"注册成功");
			eventPublisher.pushListener(emailEvent);
//			applicationContext.publishEvent(emailEvent);

			//注册成功后自动登录
			String prefix = "/static/upload/useravatar/";
			User user = userService.userLogin(new User(uemail, upwd));
			if (user != null) {
				String suffix = user.getUpic();
				if(suffix==null||suffix=="")suffix="default.jpg";
				user.setUpic(suffix);
				userService.updataUserInfo(user);
				user.setUpic(prefix+suffix);
				session.setAttribute("user", user);

			}
		}
		System.out.println(!uemail.trim().equals(""));
		return "proscenium/user/regst";
	}

	/**
	 * 跳转个人信息
	 */
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String info(String uid) {
		User user = userService.userGet(uid);
		String prefix = "/static/upload/useravatar/";
		String suffix = user.getUpic();
		user.setUpic(prefix+suffix);


		//-----------------设置城市session，供调研使用-----------------
		List<City> cities = cityDao.selectAllCity();
		session.setAttribute("cities", cities);

		session.setAttribute("user", user);
		System.out.println(user);

		return "proscenium/user/info";
	}

	/**
	 * 跳转编辑信息
	 */
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit() {
		return "proscenium/user/edit";
	}

	/**
	 * 前台用户个人信息管理
	 */
	@RequestMapping(value = "useredithandle", method = RequestMethod.POST)
	public String userEditHandle(User user) {
		//显示首页的景点
		String prefix = "/static/upload/useravatar/";
		String suffix = user.getUpic();
		user.setUpic(suffix);
		userService.updataUserInfo(user);
		user.setUpic(prefix+suffix);
		session.setAttribute("user", user);
		session.setAttribute("msg", Msg.success("用户信息更新成功!"));
		return "proscenium/user/edit";
	}

	/**
	 * 跳转用户发表管理
	 */
	@RequestMapping(value = "forum", method = RequestMethod.GET)
	public String forum(Integer uid, Model model) {
		ForumExample example = new ForumExample();
		example.setOrderByClause("tp_fid desc");
		List<Forum> forums = forumDao.selectByExample(example);
		List<Forum> queryForums = new ArrayList<>();
		for(Forum forum : forums){
			if (uid.equals(forum.getTpAuthorId())){
				queryForums.add(forum);
			}
		}
		model.addAttribute("forums", queryForums);
		return "proscenium/user/forum";
	}

	/**
	 * 用户发表管理单击删除
	 */
	@RequestMapping(value = "forumDelete", method = RequestMethod.GET)
	public String forumDelete(Integer tpFid, Integer uid, Model model) {
		forumDao.deleteByPrimaryKey(tpFid);
		ForumExample example = new ForumExample();
		example.setOrderByClause("tp_fid desc");
		List<Forum> forums = forumDao.selectByExample(example);
		List<Forum> queryForums = new ArrayList<>();
		for(Forum forum : forums){
			if (uid.equals(forum.getTpAuthorId())){
				queryForums.add(forum);
			}
		}
		model.addAttribute("forums", queryForums);
		return "proscenium/user/forum";
	}

	///**
	// * 用户发表论坛编辑
	// */
	//@RequestMapping(value = "forumEdit", method = RequestMethod.GET)
	//public String forumEdit(Integer tpFid, Model model) {
	//	Forum forum = forumDao.selectByPrimaryKey(tpFid);
	//	model.addAttribute("forum", forum);
	//	return "proscenium/user/forum_edit";
	//}


	/**
	 * 用户个人喜好调查
	 */
	@RequestMapping(value = "userlike", method = RequestMethod.POST)
	public String userlike(String uid, String tp_like[], HttpServletRequest request) {
//		User user = userService.selectByPrimaryKey(uid);
//		String userlike = "";
//		user.setTp_like(tp_like.toString());
//		for (int i = 0; i < tp_like.length; ++i) {
//			if (i < tp_like.length - 1)
//				userlike += tp_like[i] + ",";
//			else
//				userlike += tp_like[i];
//		}
//		user.setTp_like(userlike);
//		userService.updataUserInfo(user);

//		tp_like=request.getParameterValues("tp_like");
//		if(request==null){
//			Integer.parseInt("aaa");
//		}
//		else if(tp_like==null){
//			Integer.parseInt("bbb");
//		}

		for (int i = 0; i < tp_like.length; ++i) {
			userService.updataUserLike(uid,tp_like[i]);
		}


		User user = userService.userGet(uid);
		session.setAttribute("user", user);
		session.setAttribute("most",userService.userLikeCity(uid));
		return "proscenium/user/info";
	}

//	/**
//	 * yyytest
//	 */
//	@RequestMapping(value = "yyytest", method = RequestMethod.POST)
//	public String yyytest(Model model) {
//
//		try {
//			File file = new File("C:\\Users\\Hasee\\Desktop\\test.txt");
//			if(!file.exists()){
//				file.createNewFile();
//			}
//			String str = "nimasile"+userDao.selectByPrimaryKey(7).getPhone()+"||"+userDao.selectByPrimaryKey(7).getTp_like();
//			byte[] buff=str.getBytes();
//			FileOutputStream o=new FileOutputStream(file,true);
//			o.write(buff);
//			o.flush();
//			o.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "admin/login";
//	}
}
