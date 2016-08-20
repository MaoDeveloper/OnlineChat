package cn.com.beans;
/**
 * 用户登录或注册的实体类
 * @author 周华波Jays 
 * @Email jayszxs@outlook.com 
 * @QQ 794378359 
 * @version 2016-8-19
 */
public class UserInfoBean {
	private int id;
	private String name;
	private String email;
	private String password;
	private int state;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}