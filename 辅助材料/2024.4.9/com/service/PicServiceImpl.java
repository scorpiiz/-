package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PicMapper;
import com.model.Pic;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class PicServiceImpl implements PicService{
        
    @Autowired
	private PicMapper picMapper;

    //查询多条记录
	public List<Pic> queryPicList(Pic pic,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(pic, page);
		
		List<Pic> getPic = picMapper.query(map);
		return getPic;
	}
	
	//得到记录总数
	@Override
	public int getCount(Pic pic) {
		Map<String, Object> map = getQueryMap(pic, null);
		int count = picMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Pic pic,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(pic!=null){
           map.put("condition",pic.getCondition());
		   map.put("sort",pic.getSort());
           ComUtil.setModelMap(map,pic);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertPic(Pic pic) throws Exception {
		return picMapper.insertPic(pic);
	}

	//根据ID删除
	public int deletePic(int id) throws Exception {
		return picMapper.deletePic(id);
	}

	//更新
	public int updatePic(Pic pic) throws Exception {
		return picMapper.updatePic(pic);
	}
	
	//根据ID得到对应的记录
	public Pic queryPicById(int id) throws Exception {
		return picMapper.queryPicById(id);
	}

 	//判断是否存在
	public boolean exist(Pic pic)  {
		return  picMapper.exist(pic);		
	} 
}
