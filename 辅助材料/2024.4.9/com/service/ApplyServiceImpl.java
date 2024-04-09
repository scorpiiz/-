package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ApplyMapper;
import com.model.Apply;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class ApplyServiceImpl implements ApplyService{
        
    @Autowired
	private ApplyMapper applyMapper;

    //查询多条记录
	public List<Apply> queryApplyList(Apply apply,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(apply, page);
		
		List<Apply> getApply = applyMapper.query(map);
		return getApply;
	}
	
	//得到记录总数
	@Override
	public int getCount(Apply apply) {
		Map<String, Object> map = getQueryMap(apply, null);
		int count = applyMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Apply apply,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(apply!=null){
           map.put("condition",apply.getCondition());
		   map.put("sort",apply.getSort());
           ComUtil.setModelMap(map,apply);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertApply(Apply apply) throws Exception {
		return applyMapper.insertApply(apply);
	}

	//根据ID删除
	public int deleteApply(int id) throws Exception {
		return applyMapper.deleteApply(id);
	}

	//更新
	public int updateApply(Apply apply) throws Exception {
		return applyMapper.updateApply(apply);
	}
	
	//根据ID得到对应的记录
	public Apply queryApplyById(int id) throws Exception {
		return applyMapper.queryApplyById(id);
	}

 	//判断是否存在
	public boolean exist(Apply apply)  {
		return  applyMapper.exist(apply);		
	} 
}
