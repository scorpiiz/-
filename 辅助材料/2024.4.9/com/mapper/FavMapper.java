package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Fav;

public interface FavMapper {

	//返回所有记录
	public List<Fav> findFavList();

	//查询多条记录
	public List<Fav> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertFav(Fav fav);
	
	//根据ID删除	
	public int deleteFav(int id);
	
	//更新
	public int updateFav(Fav fav);
	
	//根据ID得到对应的记录
	public Fav queryFavById(int id);

	//判断是否存在
	boolean exist(Fav fav);
	
}
