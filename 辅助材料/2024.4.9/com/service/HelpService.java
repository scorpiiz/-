package com.service;
import java.util.List;

import com.model.Help;
import com.util.PageBean;

public interface HelpService{
	
	//查询多条记录
    public List<Help> queryHelpList(Help help,PageBean page) throws Exception;
 
 	//添加
	public int insertHelp(Help help) throws Exception ;
	
	//根据ID删除
	public int deleteHelp(int id) throws Exception ;
	
	//更新
	public int updateHelp(Help help) throws Exception ;
	
	//根据ID查询单条数据
	public Help queryHelpById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Help help);

    //判断是否存在
	boolean exist(Help help); 
}
