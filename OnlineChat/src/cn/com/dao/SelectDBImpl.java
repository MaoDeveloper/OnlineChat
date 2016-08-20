package cn.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.com.beans.UserInfoBean;
import cn.com.db.DBUtil;

public class SelectDBImpl implements SelectDBInf {

	@Override
	public UserInfoBean SelectUserEmailAndPwd(UserInfoBean user) {
		// TODO Auto-generated method stub
		// 设置sql语句
		String sql = "select * from userinfo where email = ? and password = ?";

		// 创建数据库
		Connection conn = DBUtil.getConnection();
		// 获取句柄
		PreparedStatement pstm = null;
		// 返回集
		ResultSet rs = null;
		// 创建接受数据的bean
		UserInfoBean userinfo = null;

		try {
			// 预编译sql语句
			pstm = conn.prepareStatement(sql);
			// 压入sql条件
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			// 发送sql语句
			rs = pstm.executeQuery();

			// 因为只有一个返回集合，所以使用if
			if (rs.next()) {
				// 存储返回的数据
				userinfo = new UserInfoBean();

				userinfo.setId(rs.getInt("id"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setName(rs.getString("name"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setState(rs.getInt("state"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.free(rs, pstm, conn);
		}


		return userinfo;
	}

	@Override
	public boolean SelectUserEmailToOne(UserInfoBean user) {
		// TODO Auto-generated method stub
		boolean bool = false;
		// 设置sql语句
		String sql = "select email from userinfo where email = ? or name = ?";
		// 创建数据库
		Connection conn = DBUtil.getConnection();
		// 获取句柄
		PreparedStatement pstm = null;
		// 返回集
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getName());
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, pstm, conn);
		}
		
		return bool;
	}

}
