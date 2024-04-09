package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.RecordMapper;
import com.model.Record;
import com.util.PageBean;
import com.util.ComUtil;

@Service
public class RecordServiceImpl implements RecordService{
        
    @Autowired
	private RecordMapper recordMapper;

    //查询多条记录
	public List<Record> queryRecordList(Record record,PageBean page) throws Exception {
		Map<String, Object> map =getQueryMap(record, page);
		
		List<Record> getRecord = recordMapper.query(map);
		return getRecord;
	}
	
	//得到记录总数
	@Override
	public int getCount(Record record) {
		Map<String, Object> map = getQueryMap(record, null);
		int count = recordMapper.getCount(map);
		return count;
	}
	
	private Map<String, Object> getQueryMap(Record record,PageBean page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(record!=null){
           map.put("condition",record.getCondition());
		   map.put("sort",record.getSort());
           ComUtil.setModelMap(map,record);
		}
		PageBean.setPageMap(map, page);
		return map;
	}
	
	
    //添加
	public int insertRecord(Record record) throws Exception {
		return recordMapper.insertRecord(record);
	}

	//根据ID删除
	public int deleteRecord(int id) throws Exception {
		return recordMapper.deleteRecord(id);
	}

	//更新
	public int updateRecord(Record record) throws Exception {
		return recordMapper.updateRecord(record);
	}
	
	//根据ID得到对应的记录
	public Record queryRecordById(int id) throws Exception {
		return recordMapper.queryRecordById(id);
	}

 	//判断是否存在
	public boolean exist(Record record)  {
		return  recordMapper.exist(record);		
	} 
}
