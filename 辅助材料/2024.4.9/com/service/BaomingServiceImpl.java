package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.BaomingMapper;
import com.model.Baoming;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class BaomingServiceImpl implements BaomingService{
        
    @Autowired
	private BaomingMapper baomingMapper;

    //查询多条记录
	public List<Baoming> queryBaomingList(Baoming baoming,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(baoming, page);
		
		List<Baoming> getBaoming = baomingMapper.query(map);
		return getBaoming;
	}
	
	//得到记录总数
	@Override
	public int getCount(Baoming baoming) {
		Map<String, Object> map = getQueryMap(baoming, null);
		int count = baomingMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Baoming baoming,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(baoming!=null){
           map.put("condition",baoming.getCondition());
		   map.put("sort",baoming.getSort());
           ComUtil.setModelMap(map,baoming);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertBaoming(Baoming baoming) throws Exception {
		return baomingMapper.insertBaoming(baoming);
	}

	//根据ID删除
	public int deleteBaoming(int id) throws Exception {
		return baomingMapper.deleteBaoming(id);
	}

	//更新
	public int updateBaoming(Baoming baoming) throws Exception {
		return baomingMapper.updateBaoming(baoming);
	}
	
	//根据ID得到对应的记录
	public Baoming queryBaomingById(int id) throws Exception {
		return baomingMapper.queryBaomingById(id);
	}

 	//判断是否存在
	public boolean exist(Baoming baoming)  {
		return  baomingMapper.exist(baoming);		
	} 
}
