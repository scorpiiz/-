package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Help;
import com.service.HelpService;
import com.service.SmsService;
import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class HelpAction{
	
	@Autowired
	private HelpService helpService;

	@Autowired
	private SmsService smsService;
	
	//查询所有活动
	@RequestMapping(value="/helpList")
	public String helpList(Help ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=helpService.getCount(ser);
		List<Help> helpList=helpService.queryHelpList(ser, page);

		req.setAttribute("helpList", helpList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/help/helpList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/helpToAdd")
	public String helpToAdd(HttpServletRequest req)throws Exception{

		return "/admin/help/helpAdd.jsp";
	}
	
	//添加活动
	@RequestMapping(value="/helpAdd")
	public String helpAdd(Help help,HttpServletRequest req)throws Exception{
		helpService.insertHelp(help);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","helpList.action");
		return "common/succeed.jsp";
	}
	
	//删除活动
	@RequestMapping(value="/helpDel")
	public String helpDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		helpService.deleteHelp(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","helpList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/tohelpEdit")
	public String tohelpEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Help help=helpService.queryHelpById(id);
		req.setAttribute("help", help);

		return "/admin/help/helpEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/tohelpView")
	public String tohelpView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Help help=helpService.queryHelpById(id);

		req.setAttribute("help", help);
		return "/admin/help/helpView.jsp";
	}

	//修改活动
	@RequestMapping(value="/helpEdit")
	public String helpEdit(Help help,HttpServletRequest req)throws Exception{
		Help po=helpService.queryHelpById(help.getId());

        int t = Integer.parseInt(req.getParameter("t"));
		if(t>0){
		   help.setZt(t==1?"进行中":"未通过");
			String zt=t==1?"通过":"拒绝";
		    smsService.insertSms(2,"活动审核消息",po.getUid(),po.getUname(),"你发布的活动"+po.getPname()+"已被审核"+zt+"");
		
		}

		helpService.updateHelp(help);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","helpList.action");
		return "common/succeed.jsp";
	}



	
}
