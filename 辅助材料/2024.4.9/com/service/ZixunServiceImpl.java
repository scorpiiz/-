package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ZixunMapper;
import com.model.Zixun;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class ZixunServiceImpl implements ZixunService{
        
    @Autowired
	private ZixunMapper zixunMapper;

    //查询多条记录
	public List<Zixun> queryZixunList(Zixun zixun,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(zixun, page);
		
		List<Zixun> getZixun = zixunMapper.query(map);
		return getZixun;
	}
	
	//得到记录总数
	@Override
	public int getCount(Zixun zixun) {
		Map<String, Object> map = getQueryMap(zixun, null);
		int count = zixunMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Zixun zixun,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(zixun!=null){
           map.put("condition",zixun.getCondition());
		   map.put("sort",zixun.getSort());
           ComUtil.setModelMap(map,zixun);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertZixun(Zixun zixun) throws Exception {
		return zixunMapper.insertZixun(zixun);
	}

	//根据ID删除
	public int deleteZixun(int id) throws Exception {
		return zixunMapper.deleteZixun(id);
	}

	//更新
	public int updateZixun(Zixun zixun) throws Exception {
		return zixunMapper.updateZixun(zixun);
	}
	
	//根据ID得到对应的记录
	public Zixun queryZixunById(int id) throws Exception {
		return zixunMapper.queryZixunById(id);
	}

 	//判断是否存在
	public boolean exist(Zixun zixun)  {
		return  zixunMapper.exist(zixun);		
	} 
}
