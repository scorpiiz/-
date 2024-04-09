package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Sms;

public interface SmsMapper {

	//返回所有记录
	public List<Sms> findSmsList();

	//查询多条记录
	public List<Sms> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertSms(Sms sms);
	
	//根据ID删除	
	public int deleteSms(int id);
	
	//更新
	public int updateSms(Sms sms);
	
	//根据ID得到对应的记录
	public Sms querySmsById(int id);

	//判断是否存在
	boolean exist(Sms sms);
	
}
