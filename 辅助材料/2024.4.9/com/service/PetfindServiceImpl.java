package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PetfindMapper;
import com.model.Petfind;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class PetfindServiceImpl implements PetfindService{
        
    @Autowired
	private PetfindMapper petfindMapper;

    //查询多条记录
	public List<Petfind> queryPetfindList(Petfind petfind,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(petfind, page);
		
		List<Petfind> getPetfind = petfindMapper.query(map);
		return getPetfind;
	}
	
	//得到记录总数
	@Override
	public int getCount(Petfind petfind) {
		Map<String, Object> map = getQueryMap(petfind, null);
		int count = petfindMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Petfind petfind,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(petfind!=null){
           map.put("condition",petfind.getCondition());
		   map.put("sort",petfind.getSort());
           ComUtil.setModelMap(map,petfind);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertPetfind(Petfind petfind) throws Exception {
		return petfindMapper.insertPetfind(petfind);
	}

	//根据ID删除
	public int deletePetfind(int id) throws Exception {
		return petfindMapper.deletePetfind(id);
	}

	//更新
	public int updatePetfind(Petfind petfind) throws Exception {
		return petfindMapper.updatePetfind(petfind);
	}
	
	//根据ID得到对应的记录
	public Petfind queryPetfindById(int id) throws Exception {
		return petfindMapper.queryPetfindById(id);
	}

 	//判断是否存在
	public boolean exist(Petfind petfind)  {
		return  petfindMapper.exist(petfind);		
	} 
}
