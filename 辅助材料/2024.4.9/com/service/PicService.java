package com.service;
import java.util.List;

import com.model.Pic;
import com.util.PageBean;

public interface PicService{
	
	//查询多条记录
    public List<Pic> queryPicList(Pic pic,PageBean page) throws Exception;
 
 	//添加
	public int insertPic(Pic pic) throws Exception ;
	
	//根据ID删除
	public int deletePic(int id) throws Exception ;
	
	//更新
	public int updatePic(Pic pic) throws Exception ;
	
	//根据ID查询单条数据
	public Pic queryPicById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Pic pic);

    //判断是否存在
	boolean exist(Pic pic); 
}
