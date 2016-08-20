package cn.com.services;

import cn.com.beans.UserInfoBean;
import cn.com.dao.AddDBImpl;
import cn.com.dao.AddDBInf;
import cn.com.dao.SelectDBImpl;
import cn.com.dao.SelectDBInf;
/**
 * 用户的登录、激活、注册操作
 * @author 周华波Jays 
 * @Email jayszxs@outlook.com 
 * @QQ 794378359 
 * @version 2016-8-19
 */
public class UserServiceImpl implements UserServiceInf {

	@Override
	public boolean regist(UserInfoBean user) {
		// TODO Auto-generated method stub
		// 判读用户名和用户邮箱的唯一性
		SelectDBInf sdb = new SelectDBImpl();
		if (sdb.SelectUserEmailToOne(user)) {
			System.out.println("用户名或邮箱已存在");
			return false;
		}
		// 获取数据库
		AddDBInf adb = new AddDBImpl();
		if (adb.AddUser(user)) {
			System.out.println("注册成功");
			return true;
		}
		
		return false;
	}

	@Override
	public UserInfoBean login(String useremail, String password) {
		// TODO Auto-generated method stub
		// 获取数据库
		SelectDBInf sdb = new SelectDBImpl();
		// 生成bean
		UserInfoBean info = new UserInfoBean();
		info.setEmail(useremail);
		info.setPassword(password);
		
		// 获取用户的详细信息，如果不存在，则为null
		UserInfoBean user = sdb.SelectUserEmailAndPwd(info);
		
		if (user == null) {
			// 用户邮箱密码错误
			return user;
		}
		
		return user;
	}

	@Override
	public void activeUser(String activecode) {
		// TODO Auto-generated method stub

	}

}
