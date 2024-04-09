package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Zixun;

public interface ZixunMapper {

	//返回所有记录
	public List<Zixun> findZixunList();

	//查询多条记录
	public List<Zixun> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertZixun(Zixun zixun);
	
	//根据ID删除	
	public int deleteZixun(int id);
	
	//更新
	public int updateZixun(Zixun zixun);
	
	//根据ID得到对应的记录
	public Zixun queryZixunById(int id);

	//判断是否存在
	boolean exist(Zixun zixun);
	
}
