package com.service;
import java.util.List;

import com.model.Adopt;
import com.util.PageBean;

public interface AdoptService{
	
	//查询多条记录
    public List<Adopt> queryAdoptList(Adopt adopt,PageBean page) throws Exception;
 
 	//添加
	public int insertAdopt(Adopt adopt) throws Exception ;
	
	//根据ID删除
	public int deleteAdopt(int id) throws Exception ;
	
	//更新
	public int updateAdopt(Adopt adopt) throws Exception ;
	
	//根据ID查询单条数据
	public Adopt queryAdoptById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Adopt adopt);

    //判断是否存在
	boolean exist(Adopt adopt); 
}
