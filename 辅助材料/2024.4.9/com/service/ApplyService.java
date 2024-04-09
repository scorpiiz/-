package com.service;
import java.util.List;

import com.model.Apply;
import com.util.PageBean;

public interface ApplyService{
	
	//查询多条记录
    public List<Apply> queryApplyList(Apply apply,PageBean page) throws Exception;
 
 	//添加
	public int insertApply(Apply apply) throws Exception ;
	
	//根据ID删除
	public int deleteApply(int id) throws Exception ;
	
	//更新
	public int updateApply(Apply apply) throws Exception ;
	
	//根据ID查询单条数据
	public Apply queryApplyById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Apply apply);

    //判断是否存在
	boolean exist(Apply apply); 
}
