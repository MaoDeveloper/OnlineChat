package cn.com.services;

import cn.com.beans.UserInfoBean;
/**
 * 用户的登录、注册、激活接口
 * @author 周华波Jays 
 * @Email jayszxs@outlook.com 
 * @QQ 794378359 
 * @version 2016-8-19
 */
public interface UserServiceInf {

	/**
	 * 注册用户操作
	 * @param user 注册用户信息
	 */
	public boolean regist(UserInfoBean user);

	/**
	 * 用户登录操作
	 * @param useremail password 用户输入的email和password
	 * @return 返回用户的详细信息
	 */
	public UserInfoBean login(String useremail, String password);

	/**
	 * 激活操作
	 * @param activecode 激活用户
	 */
	public void activeUser(String activecode);
}
