package com.service;
import java.util.List;

import com.model.Petlost;
import com.util.PageBean;

public interface PetlostService{
	
	//查询多条记录
    public List<Petlost> queryPetlostList(Petlost petlost,PageBean page) throws Exception;
 
 	//添加
	public int insertPetlost(Petlost petlost) throws Exception ;
	
	//根据ID删除
	public int deletePetlost(int id) throws Exception ;
	
	//更新
	public int updatePetlost(Petlost petlost) throws Exception ;
	
	//根据ID查询单条数据
	public Petlost queryPetlostById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Petlost petlost);

    //判断是否存在
	boolean exist(Petlost petlost); 
}
