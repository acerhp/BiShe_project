package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;

public interface UserMapper {
	//��ѯ
	public List<User> getUserList();
	//��ѯ�û��б����������ͨ��ע��ӿ�
	public List<User> findUserByIdName(@Param("username") String username,
			@Param("userid") int userid);
}
