package com.service;
import java.util.List;

import com.model.Zixun;
import com.util.PageBean;

public interface ZixunService{
	
	//查询多条记录
    public List<Zixun> queryZixunList(Zixun zixun,PageBean page) throws Exception;
 
 	//添加
	public int insertZixun(Zixun zixun) throws Exception ;
	
	//根据ID删除
	public int deleteZixun(int id) throws Exception ;
	
	//更新
	public int updateZixun(Zixun zixun) throws Exception ;
	
	//根据ID查询单条数据
	public Zixun queryZixunById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Zixun zixun);

    //判断是否存在
	boolean exist(Zixun zixun); 
}
