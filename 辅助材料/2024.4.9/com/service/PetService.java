package com.service;
import java.util.List;

import com.model.Pet;
import com.util.PageBean;

public interface PetService{
	
	//查询多条记录
    public List<Pet> queryPetList(Pet pet,PageBean page) throws Exception;
 
 	//添加
	public int insertPet(Pet pet) throws Exception ;
	
	//根据ID删除
	public int deletePet(int id) throws Exception ;
	
	//更新
	public int updatePet(Pet pet) throws Exception ;
	
	//根据ID查询单条数据
	public Pet queryPetById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Pet pet);

    //判断是否存在
	boolean exist(Pet pet); 
}
