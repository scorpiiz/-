package com.service;
import java.util.List;

import com.model.User;
import com.util.PageBean;

public interface UserService{
	
	//查询多条记录
    public List<User> queryUserList(User user,PageBean page) throws Exception;
 
 	//添加
	public int insertUser(User user) throws Exception ;
	
	//根据ID删除
	public int deleteUser(int id) throws Exception ;
	
	//更新
	public int updateUser(User user) throws Exception ;
	
	//根据ID查询单条数据
	public User queryUserById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(User user);

    //判断是否存在
	boolean exist(User user); 
}
