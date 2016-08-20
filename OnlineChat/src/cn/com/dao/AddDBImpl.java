package cn.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.com.beans.UserInfoBean;
import cn.com.db.DBUtil;

public class AddDBImpl implements AddDBInf {

	@Override
	public boolean AddUser(UserInfoBean user) {
		// TODO Auto-generated method stub
		boolean bool = false;
		// 设置sql语句
		String sql = "insert into userinfo values(seq_userinfo.nextval,?,?,?,0)";

		// 创建数据库
		Connection conn = DBUtil.getConnection();
		// 获取句柄
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getPassword());
			
			int tmp = pstm.executeUpdate();
			
			if (tmp > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.free(pstm, conn);
		}
		
		return bool;
	}

}
