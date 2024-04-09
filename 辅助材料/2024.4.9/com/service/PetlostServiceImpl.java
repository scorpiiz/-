package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PetlostMapper;
import com.model.Petlost;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class PetlostServiceImpl implements PetlostService{
        
    @Autowired
	private PetlostMapper petlostMapper;

    //查询多条记录
	public List<Petlost> queryPetlostList(Petlost petlost,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(petlost, page);
		
		List<Petlost> getPetlost = petlostMapper.query(map);
		return getPetlost;
	}
	
	//得到记录总数
	@Override
	public int getCount(Petlost petlost) {
		Map<String, Object> map = getQueryMap(petlost, null);
		int count = petlostMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Petlost petlost,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(petlost!=null){
           map.put("condition",petlost.getCondition());
		   map.put("sort",petlost.getSort());
           ComUtil.setModelMap(map,petlost);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertPetlost(Petlost petlost) throws Exception {
		return petlostMapper.insertPetlost(petlost);
	}

	//根据ID删除
	public int deletePetlost(int id) throws Exception {
		return petlostMapper.deletePetlost(id);
	}

	//更新
	public int updatePetlost(Petlost petlost) throws Exception {
		return petlostMapper.updatePetlost(petlost);
	}
	
	//根据ID得到对应的记录
	public Petlost queryPetlostById(int id) throws Exception {
		return petlostMapper.queryPetlostById(id);
	}

 	//判断是否存在
	public boolean exist(Petlost petlost)  {
		return  petlostMapper.exist(petlost);		
	} 
}
