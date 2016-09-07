package cn.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.beans.UserInfoBean;
import cn.com.services.UserServiceImpl;
import cn.com.services.UserServiceInf;

public class UserServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取界面隐藏的标记
		String method = request.getParameter("method");

		if ("login".equals(method)) { // 登录操作台
			Login(request, response);
		} else if ("regist".equals(method)) { // 注册操作
			regist(request, response);
		} else if ("logout".equals(method)) {
			// 注销操作
			//logout(request, response);
		} else if ("activeuser".equals(method)) {
			//activecode(request, response);
		}
	}
	/**
	 * 用户注册操作
	 * @param request
	 * @param response
	 */
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// 设置编码
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");

		// 获取界面提交上来的数据
		String name = request.getParameter("username");
		String email = request.getParameter("useremail");
		String password = request.getParameter("password");
		// 创建对象
		UserInfoBean user = new UserInfoBean();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		UserServiceInf service = new UserServiceImpl();
		try {
			// 注册用户
			if (service.regist(user)) {
				request.getSession().invalidate();
				request.getSession().setAttribute("user", user);
				// 将界面推送到index.jsp

				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return;
			} else {
				request.setAttribute("regist.message", "用户名或邮箱地址已被注册");
				try {
					request.getRequestDispatcher("/regist.jsp").forward(request,
							response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * 登录操作
	 * @param request
	 * @param response
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 设置编码
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");

		// 获取login.jsp提交上来的数据
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");

		// 将用户邮箱和密码传到services层判断
		UserServiceInf service = new UserServiceImpl();
		// 对用户邮箱和密码判断
		UserInfoBean user = service.login(useremail, password);
		try {
			if (user != null) {

				// 判断是否选择了记住我
				String remember = request.getParameter("remember");
				if ("1".equals(remember)) {
					Cookie cookie = new Cookie("useremail", useremail);
					// 设置cookie的时间
					cookie.setMaxAge(3*24*3600);
					// 加入cookie并且发给客户端
					response.addCookie(cookie);
				}

				// 登录成功的情况
				// 登录成功后，将用户存储到session中.
				request.getSession().invalidate();
				request.getSession().setAttribute("user", user);
				// 将界面推送到index.jsp
				response.sendRedirect(request.getContextPath() + "/chat.jsp");
				return;
			} else {
				// 登录失败的情况
				// 设置提示消息
				request.setAttribute("login.message", "用户名或密码错误");
				// 将界面推送回登录界面
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
