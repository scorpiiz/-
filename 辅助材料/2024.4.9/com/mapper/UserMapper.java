package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.User;

public interface UserMapper {

	//返回所有记录
	public List<User> findUserList();

	//查询多条记录
	public List<User> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertUser(User user);
	
	//根据ID删除	
	public int deleteUser(int id);
	
	//更新
	public int updateUser(User user);
	
	//根据ID得到对应的记录
	public User queryUserById(int id);

	//判断是否存在
	boolean exist(User user);
	
}
