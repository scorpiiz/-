package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.AdoptMapper;
import com.model.Adopt;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class AdoptServiceImpl implements AdoptService{
        
    @Autowired
	private AdoptMapper adoptMapper;

    //查询多条记录
	public List<Adopt> queryAdoptList(Adopt adopt,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(adopt, page);
		
		List<Adopt> getAdopt = adoptMapper.query(map);
		return getAdopt;
	}
	
	//得到记录总数
	@Override
	public int getCount(Adopt adopt) {
		Map<String, Object> map = getQueryMap(adopt, null);
		int count = adoptMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Adopt adopt,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(adopt!=null){
           map.put("condition",adopt.getCondition());
		   map.put("sort",adopt.getSort());
           ComUtil.setModelMap(map,adopt);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertAdopt(Adopt adopt) throws Exception {
		return adoptMapper.insertAdopt(adopt);
	}

	//根据ID删除
	public int deleteAdopt(int id) throws Exception {
		return adoptMapper.deleteAdopt(id);
	}

	//更新
	public int updateAdopt(Adopt adopt) throws Exception {
		return adoptMapper.updateAdopt(adopt);
	}
	
	//根据ID得到对应的记录
	public Adopt queryAdoptById(int id) throws Exception {
		return adoptMapper.queryAdoptById(id);
	}

 	//判断是否存在
	public boolean exist(Adopt adopt)  {
		return  adoptMapper.exist(adopt);		
	} 
}
