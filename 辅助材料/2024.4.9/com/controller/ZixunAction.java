package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Zixun;
import com.service.ZixunService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class ZixunAction{
	
	@Autowired
	private ZixunService zixunService;


	
	//查询所有宠物知识
	@RequestMapping(value="/zixunList")
	public String zixunList(Zixun ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=zixunService.getCount(ser);
		List<Zixun> zixunList=zixunService.queryZixunList(ser, page);

		req.setAttribute("zixunList", zixunList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/zixun/zixunList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/zixunToAdd")
	public String zixunToAdd(HttpServletRequest req)throws Exception{

		return "/admin/zixun/zixunAdd.jsp";
	}
	
	//添加宠物知识
	@RequestMapping(value="/zixunAdd")
	public String zixunAdd(Zixun zixun,HttpServletRequest req)throws Exception{
		zixunService.insertZixun(zixun);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","zixunList.action");
		return "common/succeed.jsp";
	}
	
	//删除宠物知识
	@RequestMapping(value="/zixunDel")
	public String zixunDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		zixunService.deleteZixun(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","zixunList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/tozixunEdit")
	public String tozixunEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Zixun zixun=zixunService.queryZixunById(id);
		req.setAttribute("zixun", zixun);

		return "/admin/zixun/zixunEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/tozixunView")
	public String tozixunView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Zixun zixun=zixunService.queryZixunById(id);

		req.setAttribute("zixun", zixun);
		return "/admin/zixun/zixunView.jsp";
	}

	//修改宠物知识
	@RequestMapping(value="/zixunEdit")
	public String zixunEdit(Zixun zixun,HttpServletRequest req)throws Exception{
		Zixun po=zixunService.queryZixunById(zixun.getId());

		zixunService.updateZixun(zixun);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","zixunList.action");
		return "common/succeed.jsp";
	}



	
}
