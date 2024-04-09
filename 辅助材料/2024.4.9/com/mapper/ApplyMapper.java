package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Apply;

public interface ApplyMapper {

	//返回所有记录
	public List<Apply> findApplyList();

	//查询多条记录
	public List<Apply> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertApply(Apply apply);
	
	//根据ID删除	
	public int deleteApply(int id);
	
	//更新
	public int updateApply(Apply apply);
	
	//根据ID得到对应的记录
	public Apply queryApplyById(int id);

	//判断是否存在
	boolean exist(Apply apply);
	
}
