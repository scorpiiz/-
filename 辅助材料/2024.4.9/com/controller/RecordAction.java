package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Record;
import com.service.RecordService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class RecordAction{
	
	@Autowired
	private RecordService recordService;


	
	//查询所有活动打卡
	@RequestMapping(value="/recordList")
	public String recordList(Record ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=recordService.getCount(ser);
		List<Record> recordList=recordService.queryRecordList(ser, page);

		req.setAttribute("recordList", recordList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/record/recordList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/recordToAdd")
	public String recordToAdd(HttpServletRequest req)throws Exception{

		return "/admin/record/recordAdd.jsp";
	}
	
	//添加活动打卡
	@RequestMapping(value="/recordAdd")
	public String recordAdd(Record record,HttpServletRequest req)throws Exception{
		recordService.insertRecord(record);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","recordList.action");
		return "common/succeed.jsp";
	}
	
	//删除活动打卡
	@RequestMapping(value="/recordDel")
	public String recordDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		recordService.deleteRecord(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","recordList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/torecordEdit")
	public String torecordEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Record record=recordService.queryRecordById(id);
		req.setAttribute("record", record);

		return "/admin/record/recordEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/torecordView")
	public String torecordView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Record record=recordService.queryRecordById(id);

		req.setAttribute("record", record);
		return "/admin/record/recordView.jsp";
	}

	//修改活动打卡
	@RequestMapping(value="/recordEdit")
	public String recordEdit(Record record,HttpServletRequest req)throws Exception{
		Record po=recordService.queryRecordById(record.getId());

		recordService.updateRecord(record);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","recordList.action");
		return "common/succeed.jsp";
	}



	
}
