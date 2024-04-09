package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Petfind;
import com.service.PetfindService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class PetfindAction{
	
	@Autowired
	private PetfindService petfindService;


	
	//查询所有寻回记录
	@RequestMapping(value="/petfindList")
	public String petfindList(Petfind ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=petfindService.getCount(ser);
		List<Petfind> petfindList=petfindService.queryPetfindList(ser, page);

		req.setAttribute("petfindList", petfindList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/petfind/petfindList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/petfindToAdd")
	public String petfindToAdd(HttpServletRequest req)throws Exception{

		return "/admin/petfind/petfindAdd.jsp";
	}
	
	//添加寻回记录
	@RequestMapping(value="/petfindAdd")
	public String petfindAdd(Petfind petfind,HttpServletRequest req)throws Exception{
		petfindService.insertPetfind(petfind);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","petfindList.action");
		return "common/succeed.jsp";
	}
	
	//删除寻回记录
	@RequestMapping(value="/petfindDel")
	public String petfindDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		petfindService.deletePetfind(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","petfindList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/topetfindEdit")
	public String topetfindEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Petfind petfind=petfindService.queryPetfindById(id);
		req.setAttribute("petfind", petfind);

		return "/admin/petfind/petfindEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/topetfindView")
	public String topetfindView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Petfind petfind=petfindService.queryPetfindById(id);

		req.setAttribute("petfind", petfind);
		return "/admin/petfind/petfindView.jsp";
	}

	//修改寻回记录
	@RequestMapping(value="/petfindEdit")
	public String petfindEdit(Petfind petfind,HttpServletRequest req)throws Exception{
		Petfind po=petfindService.queryPetfindById(petfind.getId());

		petfindService.updatePetfind(petfind);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","petfindList.action");
		return "common/succeed.jsp";
	}



	
}
