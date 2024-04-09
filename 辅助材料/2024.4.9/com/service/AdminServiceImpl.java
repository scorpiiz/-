package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.AdminMapper;
import com.model.Admin;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class AdminServiceImpl implements AdminService{
        
    @Autowired
	private AdminMapper adminMapper;

    //查询多条记录
	public List<Admin> queryAdminList(Admin admin,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(admin, page);
		
		List<Admin> getAdmin = adminMapper.query(map);
		return getAdmin;
	}
	
	//得到记录总数
	@Override
	public int getCount(Admin admin) {
		Map<String, Object> map = getQueryMap(admin, null);
		int count = adminMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Admin admin,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(admin!=null){
           map.put("condition",admin.getCondition());
		   map.put("sort",admin.getSort());
           ComUtil.setModelMap(map,admin);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertAdmin(Admin admin) throws Exception {
		return adminMapper.insertAdmin(admin);
	}

	//根据ID删除
	public int deleteAdmin(int id) throws Exception {
		return adminMapper.deleteAdmin(id);
	}

	//更新
	public int updateAdmin(Admin admin) throws Exception {
		return adminMapper.updateAdmin(admin);
	}
	
	//根据ID得到对应的记录
	public Admin queryAdminById(int id) throws Exception {
		return adminMapper.queryAdminById(id);
	}

 	//判断是否存在
	public boolean exist(Admin admin)  {
		return  adminMapper.exist(admin);		
	} 
}
