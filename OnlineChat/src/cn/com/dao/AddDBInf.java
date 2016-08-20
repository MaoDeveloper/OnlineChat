package cn.com.dao;

import cn.com.beans.UserInfoBean;

/**
 * 对数据的插入修改操作接口
 * @author 周华波Jays 
 * @Email jayszxs@outlook.com 
 * @QQ 794378359 
 * @version 2016-8-19
 */
public interface AddDBInf {
	/**
	 * 用户注册时对db进行插入
	 * @param user 用户注册的信息
	 * @return 返回是否注册成功
	 */
	public boolean AddUser(UserInfoBean user);
}
