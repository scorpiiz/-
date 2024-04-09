package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Adopt;
import com.model.Apply;
import com.service.AdoptService;
import com.service.ApplyService;
import com.service.SmsService;
import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class ApplyAction{
	
	@Autowired
	private ApplyService applyService;

	@Autowired
	private SmsService smsService;

	@Autowired
	private AdoptService adoptService;
	
	//查询所有申请记录
	@RequestMapping(value="/applyList")
	public String applyList(Apply ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=applyService.getCount(ser);
		List<Apply> applyList=applyService.queryApplyList(ser, page);

		req.setAttribute("applyList", applyList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/apply/applyList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/applyToAdd")
	public String applyToAdd(HttpServletRequest req)throws Exception{

		return "/admin/apply/applyAdd.jsp";
	}
	
	//添加申请记录
	@RequestMapping(value="/applyAdd")
	public String applyAdd(Apply apply,HttpServletRequest req)throws Exception{
		applyService.insertApply(apply);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","applyList.action");
		return "common/succeed.jsp";
	}
	
	//删除申请记录
	@RequestMapping(value="/applyDel")
	public String applyDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		applyService.deleteApply(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","applyList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/toapplyEdit")
	public String toapplyEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Apply apply=applyService.queryApplyById(id);
		req.setAttribute("apply", apply);

		return "/admin/apply/applyEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/toapplyView")
	public String toapplyView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Apply apply=applyService.queryApplyById(id);

		req.setAttribute("apply", apply);
		return "/admin/apply/applyView.jsp";
	}

	//修改申请记录
	@RequestMapping(value="/applyEdit")
	public String applyEdit(Apply apply,HttpServletRequest req)throws Exception{
		Apply po=applyService.queryApplyById(apply.getId());

        int t = Integer.parseInt(req.getParameter("t"));
		if(t>0){
		   apply.setZt(t==1?"已通过":"已拒绝");
           String zt=t==1?"通过":"拒绝";
		   smsService.insertSms(1,"领养审核消息",po.getUid(),po.getUname(),"你申请领养的"+po.getCname()+"已被审核"+zt);
		
		   if(t==1){
		   int cid=po.getCid();
		   Adopt poo=adoptService.queryAdoptById(cid);
           Adopt adopt= new Adopt();
		   adopt.setId(po.getCid());
		   adopt.setZt("已领养");
		   adoptService.updateAdopt(adopt);

		   smsService.insertSms(1,"领养审核消息",poo.getUid(),poo.getUname(),"你发布的领养"+poo.getPname()+"已被"+po.getUname()+"领养成功");
		
		   }
		
		}

		applyService.updateApply(apply);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","applyList.action");
		return "common/succeed.jsp";
	}



	
}
