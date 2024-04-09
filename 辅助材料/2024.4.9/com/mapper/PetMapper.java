package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Pet;

public interface PetMapper {

	//返回所有记录
	public List<Pet> findPetList();

	//查询多条记录
	public List<Pet> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertPet(Pet pet);
	
	//根据ID删除	
	public int deletePet(int id);
	
	//更新
	public int updatePet(Pet pet);
	
	//根据ID得到对应的记录
	public Pet queryPetById(int id);

	//判断是否存在
	boolean exist(Pet pet);
	
}
