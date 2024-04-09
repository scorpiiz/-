package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.FavMapper;
import com.model.Fav;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class FavServiceImpl implements FavService{
        
    @Autowired
	private FavMapper favMapper;

    //查询多条记录
	public List<Fav> queryFavList(Fav fav,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(fav, page);
		
		List<Fav> getFav = favMapper.query(map);
		return getFav;
	}
	
	//得到记录总数
	@Override
	public int getCount(Fav fav) {
		Map<String, Object> map = getQueryMap(fav, null);
		int count = favMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Fav fav,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(fav!=null){
           map.put("condition",fav.getCondition());
		   map.put("sort",fav.getSort());
           ComUtil.setModelMap(map,fav);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertFav(Fav fav) throws Exception {
		return favMapper.insertFav(fav);
	}

	//根据ID删除
	public int deleteFav(int id) throws Exception {
		return favMapper.deleteFav(id);
	}

	//更新
	public int updateFav(Fav fav) throws Exception {
		return favMapper.updateFav(fav);
	}
	
	//根据ID得到对应的记录
	public Fav queryFavById(int id) throws Exception {
		return favMapper.queryFavById(id);
	}

 	//判断是否存在
	public boolean exist(Fav fav)  {
		return  favMapper.exist(fav);		
	} 
}
