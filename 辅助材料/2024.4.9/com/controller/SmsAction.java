package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Sms;
import com.service.SmsService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class SmsAction{
	
	@Autowired
	private SmsService smsService;


	
	//查询所有消息
	@RequestMapping(value="/smsList")
	public String smsList(Sms ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=smsService.getCount(ser);
		List<Sms> smsList=smsService.querySmsList(ser, page);

		req.setAttribute("smsList", smsList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/sms/smsList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/smsToAdd")
	public String smsToAdd(HttpServletRequest req)throws Exception{

		return "/admin/sms/smsAdd.jsp";
	}
	
	//添加消息
	@RequestMapping(value="/smsAdd")
	public String smsAdd(Sms sms,HttpServletRequest req)throws Exception{
		smsService.insertSms(sms);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","smsList.action");
		return "common/succeed.jsp";
	}
	
	//删除消息
	@RequestMapping(value="/smsDel")
	public String smsDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		smsService.deleteSms(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","smsList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/tosmsEdit")
	public String tosmsEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Sms sms=smsService.querySmsById(id);
		req.setAttribute("sms", sms);

		return "/admin/sms/smsEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/tosmsView")
	public String tosmsView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Sms sms=smsService.querySmsById(id);

		req.setAttribute("sms", sms);
		return "/admin/sms/smsView.jsp";
	}

	//修改消息
	@RequestMapping(value="/smsEdit")
	public String smsEdit(Sms sms,HttpServletRequest req)throws Exception{
		Sms po=smsService.querySmsById(sms.getId());

		smsService.updateSms(sms);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","smsList.action");
		return "common/succeed.jsp";
	}



	
}
