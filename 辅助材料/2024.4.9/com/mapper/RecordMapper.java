package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Record;

public interface RecordMapper {

	//返回所有记录
	public List<Record> findRecordList();

	//查询多条记录
	public List<Record> query(Map<String,Object> inputParam);
	
	//得到记录总数
	int getCount(Map<String,Object> inputParam);
	
	//添加
	public int insertRecord(Record record);
	
	//根据ID删除	
	public int deleteRecord(int id);
	
	//更新
	public int updateRecord(Record record);
	
	//根据ID得到对应的记录
	public Record queryRecordById(int id);

	//判断是否存在
	boolean exist(Record record);
	
}
