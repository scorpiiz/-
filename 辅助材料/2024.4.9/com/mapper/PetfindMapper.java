package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Petfind;

public interface PetfindMapper {

	//返回所有记录
	public List<Petfind> findPetfindList();

	//查询多条记录
	public List<Petfind> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertPetfind(Petfind petfind);
	
	//根据ID删除	
	public int deletePetfind(int id);
	
	//更新
	public int updatePetfind(Petfind petfind);
	
	//根据ID得到对应的记录
	public Petfind queryPetfindById(int id);

	//判断是否存在
	boolean exist(Petfind petfind);
	
}
