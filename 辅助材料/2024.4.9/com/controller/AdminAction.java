package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Admin;
import com.service.AdminService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class AdminAction{
	
	@Autowired
	private AdminService adminService;


	
	//查询所有管理员
	@RequestMapping(value="/adminList")
	public String adminList(Admin ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=adminService.getCount(ser);
		List<Admin> adminList=adminService.queryAdminList(ser, page);

		req.setAttribute("adminList", adminList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/admin/adminList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/adminToAdd")
	public String adminToAdd(HttpServletRequest req)throws Exception{

		return "/admin/admin/adminAdd.jsp";
	}
	
	//添加管理员
	@RequestMapping(value="/adminAdd")
	public String adminAdd(Admin admin,HttpServletRequest req)throws Exception{
		adminService.insertAdmin(admin);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","adminList.action");
		return "common/succeed.jsp";
	}
	
	//删除管理员
	@RequestMapping(value="/adminDel")
	public String adminDel(HttpServletRequest req)throws Exception{
		int aid = Integer.parseInt(req.getParameter("aid"));
		adminService.deleteAdmin(aid);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","adminList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/toadminEdit")
	public String toadminEdit(HttpServletRequest req)throws Exception{
		int aid = Integer.parseInt(req.getParameter("aid"));
		Admin admin=adminService.queryAdminById(aid);
		req.setAttribute("admin", admin);

		return "/admin/admin/adminEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/toadminView")
	public String toadminView(HttpServletRequest req)throws Exception{
		int aid = Integer.parseInt(req.getParameter("aid"));
		Admin admin=adminService.queryAdminById(aid);

		req.setAttribute("admin", admin);
		return "/admin/admin/adminView.jsp";
	}

	//修改管理员
	@RequestMapping(value="/adminEdit")
	public String adminEdit(Admin admin,HttpServletRequest req)throws Exception{
		Admin po=adminService.queryAdminById(admin.getAid());

		adminService.updateAdmin(admin);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","adminList.action");
		return "common/succeed.jsp";
	}



	
}
