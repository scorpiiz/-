package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Help;

public interface HelpMapper {

	//返回所有记录
	public List<Help> findHelpList();

	//查询多条记录
	public List<Help> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertHelp(Help help);
	
	//根据ID删除	
	public int deleteHelp(int id);
	
	//更新
	public int updateHelp(Help help);
	
	//根据ID得到对应的记录
	public Help queryHelpById(int id);

	//判断是否存在
	boolean exist(Help help);
	
}
