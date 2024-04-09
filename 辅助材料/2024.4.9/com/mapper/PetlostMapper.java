package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Petlost;

public interface PetlostMapper {

	//返回所有记录
	public List<Petlost> findPetlostList();

	//查询多条记录
	public List<Petlost> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertPetlost(Petlost petlost);
	
	//根据ID删除	
	public int deletePetlost(int id);
	
	//更新
	public int updatePetlost(Petlost petlost);
	
	//根据ID得到对应的记录
	public Petlost queryPetlostById(int id);

	//判断是否存在
	boolean exist(Petlost petlost);
	
}
