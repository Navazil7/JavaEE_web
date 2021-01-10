package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.User;

import java.util.List;

public interface UserService {
	/**
	 * 插入用户
	 * @param
	 */
	void insertUser(String uname, String email, String upwd);

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> selectAll();

	/**
	 * 查询用户名
	 * @return
	 */

	User selectbyname(String name);
	/**
	 * 查询用户邮箱
	 * @return
	 */
	User selectbyemail(String email);

	/**
	 * 搜索功能
	 * @param keyword
	 * @return
	 */
	List<User> search(String keyword);

	/**
	 * 根据uid删除用户
	 * @param uid
	 */
	void userDelete(String uid);

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User userLogin(User user);

	/**
	 * @param uid
	 * @return
	 */
	User userGet(String uid);

	/**
	 * 用户信息新增
	 */
	void updataUserInfo(User user);

	/**
	 * 根据uid查找用户
	 */
	User findUser(String uid);


	/**
	 * 用户喜好更新
	 */
	void updataUserLike(String uid, String vtype);

	/**
	 * 返回用户最喜好的城市
	 */
	public String userLikeVtype(String uid);
}
