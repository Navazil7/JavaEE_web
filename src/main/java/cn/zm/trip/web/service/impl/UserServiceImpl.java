package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.dao.OrderMapper;
import cn.zm.trip.web.dao.UserDao;
import cn.zm.trip.web.domain.OrderExample;
import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.service.ForumService;
import cn.zm.trip.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	private ForumService forumService;

	@Override
	public void insertUser(String uname, String uemail, String upwd) {
		userDao.insertUser(new User(uname, uemail, upwd));
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public User selectbyname(String name) {
		return userDao.selectbyname(name);
	}

	@Override
	public User selectbyemail(String email) {
		return userDao.selectbyemail(email);
	}

	@Override
	public List<User> search(String keyword) {
		User user = new User();
		user.setUid(keyword);
		user.setUname(keyword);
		user.setUemail(keyword);
		return userDao.search(user);
	}

	@Override
	public void userDelete(String uid) {
//		OrderExample example = new OrderExample();
//		OrderExample.Criteria criteria = example.createCriteria();
//		criteria.andTpUidEqualTo()

		userDao.userDelete(uid);
	}

	@Override
	public User userLogin(User user) {
		User loginUser = userDao.userLogin(user);
		return loginUser;
	}

	@Override
	public User userGet(String uid) {
		User user = userDao.selectByPrimaryKey(Integer.parseInt(uid));
		return user;
	}

	@Override
	public void updataUserInfo(User user) {
		userDao.updataUserInfo(user);
	}


	@Override
	public User findUser(String uid){
		return userDao.selectByPrimaryKey(Integer.parseInt(uid));
	}

	/**
	 * 用户喜好更新
	 */
	@Override
	public void updataUserLike(String uid, String vtype) {
		User user = userDao.selectByPrimaryKey(Integer.parseInt(uid));
		String like=user.getTp_like();
		String newlike="";

//		Logger log = Logger.getLogger(this.getClass());
//		log.info(like);

		if(like==null || like.equals("")){
			newlike+=vtype+":1#";
		}
		else{
			boolean flag=true;
			String likes[] = like.split("#");
			for(int i=0;i<likes.length;i++){
				String cityandnum[]=likes[i].split(":");
				if(cityandnum[0].equals(vtype)){
					int num=Integer.parseInt(cityandnum[1]);
					cityandnum[1]=String.valueOf(num+1);
					flag=false;
				}
				newlike+=cityandnum[0]+":"+cityandnum[1]+"#";
			}
			if(flag){
				newlike+=vtype+":1#";
			}
		}
		user.setTp_like(newlike);
		userDao.updataUserInfo(user);

		try {
			File file = new File("C:\\Users\\Hasee\\Desktop\\test.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			String str = "newlike:"+newlike+"\n";
			byte[] buff=str.getBytes();
			FileOutputStream o=new FileOutputStream(file,true);
			o.write(buff);
			o.flush();
			o.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		userDao.updataUserLike(uid,newlike);

//		try {
//			File file = new File("C:\\Users\\Hasee\\Desktop\\test.txt");
//			if(!file.exists()){
//				file.createNewFile();
//			}
//			String str = "更新完"+userDao.userGet(uid).getTp_like()+"\n";
//			byte[] buff=str.getBytes();
//			FileOutputStream o=new FileOutputStream(file,true);
//			o.write(buff);
//			o.flush();
//			o.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}


	/**
	 * 返回用户最喜欢的景点类型
	 */
	@Override
	public String userLikeVtype(String uid){
		User user = userDao.selectByPrimaryKey(Integer.parseInt(uid));
		int maxnum=0;
		String city=null;

		String like=user.getTp_like();
		if(like==null||like.equals("")){
			return "";
		}
		String likes[] = like.split("#");
		for(int i=0;i<likes.length;i++){
			String cityandnum[]=likes[i].split(":");
			int num=Integer.parseInt(cityandnum[1]);
			if(num>=maxnum){
				maxnum=num;
				city=cityandnum[0];
			}
		}
		return city;
	}
}
