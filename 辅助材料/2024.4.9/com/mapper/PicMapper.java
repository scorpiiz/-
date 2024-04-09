package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Pic;

public interface PicMapper {

	//返回所有记录
	public List<Pic> findPicList();

	//查询多条记录
	public List<Pic> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertPic(Pic pic);
	
	//根据ID删除	
	public int deletePic(int id);
	
	//更新
	public int updatePic(Pic pic);
	
	//根据ID得到对应的记录
	public Pic queryPicById(int id);

	//判断是否存在
	boolean exist(Pic pic);
	
}
