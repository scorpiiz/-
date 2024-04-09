package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.SmsMapper;
import com.model.Sms;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class SmsServiceImpl implements SmsService{
        
    @Autowired
	private SmsMapper smsMapper;

    //查询多条记录
	public List<Sms> querySmsList(Sms sms,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(sms, page);
		
		List<Sms> getSms = smsMapper.query(map);
		return getSms;
	}
	
	//得到记录总数
	@Override
	public int getCount(Sms sms) {
		Map<String, Object> map = getQueryMap(sms, null);
		int count = smsMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Sms sms,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(sms!=null){
           map.put("condition",sms.getCondition());
		   map.put("sort",sms.getSort());
           ComUtil.setModelMap(map,sms);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertSms(Sms sms) throws Exception {
		return smsMapper.insertSms(sms);
	}

	//根据ID删除
	public int deleteSms(int id) throws Exception {
		return smsMapper.deleteSms(id);
	}

	//更新
	public int updateSms(Sms sms) throws Exception {
		return smsMapper.updateSms(sms);
	}
	
	//根据ID得到对应的记录
	public Sms querySmsById(int id) throws Exception {
		return smsMapper.querySmsById(id);
	}

 	//判断是否存在
	public boolean exist(Sms sms)  {
		return  smsMapper.exist(sms);		
	}
	
	//添加
	public int insertSms(int uid,String uname,int sid,String sname,String cont) throws Exception{
		
		Sms sms= new Sms();
		sms.setUid(uid);
		sms.setUname(uname);
		sms.setSid(sid);
		sms.setSname(sname);
		sms.setCont(cont);

		return insertSms(sms);
	}
}
