package com.service;
import java.util.List;

import com.model.Baoming;
import com.util.PageBean;

public interface BaomingService{
	
	//查询多条记录
    public List<Baoming> queryBaomingList(Baoming baoming,PageBean page) throws Exception;
 
 	//添加
	public int insertBaoming(Baoming baoming) throws Exception ;
	
	//根据ID删除
	public int deleteBaoming(int id) throws Exception ;
	
	//更新
	public int updateBaoming(Baoming baoming) throws Exception ;
	
	//根据ID查询单条数据
	public Baoming queryBaomingById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Baoming baoming);

    //判断是否存在
	boolean exist(Baoming baoming); 
}
