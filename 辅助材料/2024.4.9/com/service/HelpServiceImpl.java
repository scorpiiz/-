package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.HelpMapper;
import com.model.Help;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class HelpServiceImpl implements HelpService{
        
    @Autowired
	private HelpMapper helpMapper;

    //查询多条记录
	public List<Help> queryHelpList(Help help,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(help, page);
		
		List<Help> getHelp = helpMapper.query(map);
		return getHelp;
	}
	
	//得到记录总数
	@Override
	public int getCount(Help help) {
		Map<String, Object> map = getQueryMap(help, null);
		int count = helpMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Help help,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(help!=null){
           map.put("condition",help.getCondition());
		   map.put("sort",help.getSort());
           ComUtil.setModelMap(map,help);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertHelp(Help help) throws Exception {
		return helpMapper.insertHelp(help);
	}

	//根据ID删除
	public int deleteHelp(int id) throws Exception {
		return helpMapper.deleteHelp(id);
	}

	//更新
	public int updateHelp(Help help) throws Exception {
		return helpMapper.updateHelp(help);
	}
	
	//根据ID得到对应的记录
	public Help queryHelpById(int id) throws Exception {
		return helpMapper.queryHelpById(id);
	}

 	//判断是否存在
	public boolean exist(Help help)  {
		return  helpMapper.exist(help);		
	} 
}
