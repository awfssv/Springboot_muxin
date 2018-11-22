package com.mexbo.service;
import com.mexbo.pojo.Users;

public interface UserService {

	/**
	 * @Description: 判断用户名是否存在
	 */
	public boolean queryUsernameIsExist(String username);
	
	/**
	 * @Description: 查询用户是否存在
	 */
	public Users queryUserForLogin(String username, String pwd);
	
	/**
	 * @Description: 用户注册
	 */
	public Users saveUser(Users user);
	
	/**
	 * @Description: 修改用户记录
	 */
	public Users updateUserInfo(Users user);
	
}
