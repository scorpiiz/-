package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.model.User;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class UserServiceImpl implements UserService{
        
    @Autowired
	private UserMapper userMapper;

    //查询多条记录
	public List<User> queryUserList(User user,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(user, page);
		
		List<User> getUser = userMapper.query(map);
		return getUser;
	}
	
	//得到记录总数
	@Override
	public int getCount(User user) {
		Map<String, Object> map = getQueryMap(user, null);
		int count = userMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(User user,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(user!=null){
           map.put("condition",user.getCondition());
		   map.put("sort",user.getSort());
           ComUtil.setModelMap(map,user);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertUser(User user) throws Exception {
		return userMapper.insertUser(user);
	}

	//根据ID删除
	public int deleteUser(int id) throws Exception {
		return userMapper.deleteUser(id);
	}

	//更新
	public int updateUser(User user) throws Exception {
		return userMapper.updateUser(user);
	}
	
	//根据ID得到对应的记录
	public User queryUserById(int id) throws Exception {
		return userMapper.queryUserById(id);
	}

 	//判断是否存在
	public boolean exist(User user)  {
		return  userMapper.exist(user);		
	} 
}
