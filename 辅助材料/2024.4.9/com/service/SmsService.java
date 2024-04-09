package com.service;
import java.util.List;

import com.model.Sms;
import com.util.PageBean;

public interface SmsService{
	
	//查询多条记录
    public List<Sms> querySmsList(Sms sms,PageBean page) throws Exception;
 
 	//添加
	public int insertSms(Sms sms) throws Exception ;
	
	//根据ID删除
	public int deleteSms(int id) throws Exception ;
	
	//更新
	public int updateSms(Sms sms) throws Exception ;
	
	//根据ID查询单条数据
	public Sms querySmsById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Sms sms);

    //判断是否存在
	boolean exist(Sms sms); 

	//添加
	public int insertSms(int uid,String uname,int sid,String sname,String cont) throws Exception ;
}
