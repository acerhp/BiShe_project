package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;

public interface UserMapper {
	//查询
	public List<User> getUserList();
	//查询用户列表——多参数，通过注解接口
	public List<User> findUserByIdName(@Param("username") String username,
			@Param("userid") int userid);
}
