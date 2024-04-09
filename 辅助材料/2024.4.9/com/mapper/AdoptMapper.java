package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Adopt;

public interface AdoptMapper {

	//返回所有记录
	public List<Adopt> findAdoptList();

	//查询多条记录
	public List<Adopt> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertAdopt(Adopt adopt);
	
	//根据ID删除	
	public int deleteAdopt(int id);
	
	//更新
	public int updateAdopt(Adopt adopt);
	
	//根据ID得到对应的记录
	public Adopt queryAdoptById(int id);

	//判断是否存在
	boolean exist(Adopt adopt);
	
}
