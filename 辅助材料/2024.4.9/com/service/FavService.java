package com.service;
import java.util.List;

import com.model.Fav;
import com.util.PageBean;

public interface FavService{
	
	//查询多条记录
    public List<Fav> queryFavList(Fav fav,PageBean page) throws Exception;
 
 	//添加
	public int insertFav(Fav fav) throws Exception ;
	
	//根据ID删除
	public int deleteFav(int id) throws Exception ;
	
	//更新
	public int updateFav(Fav fav) throws Exception ;
	
	//根据ID查询单条数据
	public Fav queryFavById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Fav fav);

    //判断是否存在
	boolean exist(Fav fav); 
}
