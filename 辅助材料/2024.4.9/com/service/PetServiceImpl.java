package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PetMapper;
import com.model.Pet;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class PetServiceImpl implements PetService{
        
    @Autowired
	private PetMapper petMapper;

    //查询多条记录
	public List<Pet> queryPetList(Pet pet,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(pet, page);
		
		List<Pet> getPet = petMapper.query(map);
		return getPet;
	}
	
	//得到记录总数
	@Override
	public int getCount(Pet pet) {
		Map<String, Object> map = getQueryMap(pet, null);
		int count = petMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Pet pet,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(pet!=null){
           map.put("condition",pet.getCondition());
		   map.put("sort",pet.getSort());
           ComUtil.setModelMap(map,pet);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertPet(Pet pet) throws Exception {
		return petMapper.insertPet(pet);
	}

	//根据ID删除
	public int deletePet(int id) throws Exception {
		return petMapper.deletePet(id);
	}

	//更新
	public int updatePet(Pet pet) throws Exception {
		return petMapper.updatePet(pet);
	}
	
	//根据ID得到对应的记录
	public Pet queryPetById(int id) throws Exception {
		return petMapper.queryPetById(id);
	}

 	//判断是否存在
	public boolean exist(Pet pet)  {
		return  petMapper.exist(pet);		
	} 
}
