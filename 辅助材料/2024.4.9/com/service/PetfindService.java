package com.service;
import java.util.List;

import com.model.Petfind;
import com.util.PageBean;

public interface PetfindService{
	
	//查询多条记录
    public List<Petfind> queryPetfindList(Petfind petfind,PageBean page) throws Exception;
 
 	//添加
	public int insertPetfind(Petfind petfind) throws Exception ;
	
	//根据ID删除
	public int deletePetfind(int id) throws Exception ;
	
	//更新
	public int updatePetfind(Petfind petfind) throws Exception ;
	
	//根据ID查询单条数据
	public Petfind queryPetfindById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Petfind petfind);

    //判断是否存在
	boolean exist(Petfind petfind); 
}
