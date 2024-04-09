package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Baoming;
import com.service.BaomingService;
import com.service.SmsService;
import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class BaomingAction{
	
	@Autowired
	private BaomingService baomingService;

	@Autowired
	private SmsService smsService;
	
	//查询所有活动报名
	@RequestMapping(value="/baomingList")
	public String baomingList(Baoming ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=baomingService.getCount(ser);
		List<Baoming> baomingList=baomingService.queryBaomingList(ser, page);

		req.setAttribute("baomingList", baomingList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/baoming/baomingList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/baomingToAdd")
	public String baomingToAdd(HttpServletRequest req)throws Exception{

		return "/admin/baoming/baomingAdd.jsp";
	}
	
	//添加活动报名
	@RequestMapping(value="/baomingAdd")
	public String baomingAdd(Baoming baoming,HttpServletRequest req)throws Exception{
		baomingService.insertBaoming(baoming);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","baomingList.action");
		return "common/succeed.jsp";
	}
	
	//删除活动报名
	@RequestMapping(value="/baomingDel")
	public String baomingDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		baomingService.deleteBaoming(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","baomingList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/tobaomingEdit")
	public String tobaomingEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Baoming baoming=baomingService.queryBaomingById(id);
		req.setAttribute("baoming", baoming);

		return "/admin/baoming/baomingEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/tobaomingView")
	public String tobaomingView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Baoming baoming=baomingService.queryBaomingById(id);

		req.setAttribute("baoming", baoming);
		return "/admin/baoming/baomingView.jsp";
	}

	//修改活动报名
	@RequestMapping(value="/baomingEdit")
	public String baomingEdit(Baoming baoming,HttpServletRequest req)throws Exception{
		Baoming po=baomingService.queryBaomingById(baoming.getId());

         int t = Integer.parseInt(req.getParameter("t"));
		if(t>0){
		   baoming.setZt(t==1?"已通过":"已拒绝");
			String zt=t==1?"通过":"拒绝";
		    smsService.insertSms(2,"活动报名审核消息",po.getUid(),po.getUname(),"你报名的活动"+po.getCname()+"已被审核"+zt+"");
		
		}


		baomingService.updateBaoming(baoming);

	

		req.setAttribute("message","操作成功");
		req.setAttribute("path","baomingList.action");
		return "common/succeed.jsp";
	}



	
}
