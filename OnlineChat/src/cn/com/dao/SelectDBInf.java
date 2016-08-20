package cn.com.dao;

import cn.com.beans.UserInfoBean;

/**
 * 对数据进行查询操作
 * @author 周华波Jays 
 * @Email jayszxs@outlook.com 
 * @QQ 794378359 
 * @version 2016-8-19
 */
public interface SelectDBInf {

	/**
	 * 根据用户邮箱查找该用户的所有信息
	 * @param user 查询条件
	 * @return 该用户的所有属性
	 */
	public UserInfoBean SelectUserEmailAndPwd(UserInfoBean user);
	/**
	 * 判断用户邮箱和用户名的唯一性
	 * @param user 用户注册信息
	 * @return 是否存在
	 */
	public boolean SelectUserEmailToOne(UserInfoBean user);
}
