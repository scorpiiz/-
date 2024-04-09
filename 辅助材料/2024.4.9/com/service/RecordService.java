package com.service;
import java.util.List;

import com.model.Record;
import com.util.PageBean;

public interface RecordService{
	
	//查询多条记录
    public List<Record> queryRecordList(Record record,PageBean page) throws Exception;
 
 	//添加
	public int insertRecord(Record record) throws Exception ;
	
	//根据ID删除
	public int deleteRecord(int id) throws Exception ;
	
	//更新
	public int updateRecord(Record record) throws Exception ;
	
	//根据ID查询单条数据
	public Record queryRecordById(int id) throws Exception ;
		
	//得到记录总数
	int getCount(Record record);

    //判断是否存在
	boolean exist(Record record); 
}
