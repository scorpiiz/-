package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Baoming;

public interface BaomingMapper {

	//返回所有记录
	public List<Baoming> findBaomingList();

	//查询多条记录
	public List<Baoming> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertBaoming(Baoming baoming);
	
	//根据ID删除	
	public int deleteBaoming(int id);
	
	//更新
	public int updateBaoming(Baoming baoming);
	
	//根据ID得到对应的记录
	public Baoming queryBaomingById(int id);

	//判断是否存在
	boolean exist(Baoming baoming);
	
}
