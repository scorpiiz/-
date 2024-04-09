package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Petlost;
import com.service.PetlostService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class PetlostAction{
	
	@Autowired
	private PetlostService petlostService;


	
	//查询所有宠物寻回
	@RequestMapping(value="/petlostList")
	public String petlostList(Petlost ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=petlostService.getCount(ser);
		List<Petlost> petlostList=petlostService.queryPetlostList(ser, page);

		req.setAttribute("petlostList", petlostList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/petlost/petlostList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/petlostToAdd")
	public String petlostToAdd(HttpServletRequest req)throws Exception{

		return "/admin/petlost/petlostAdd.jsp";
	}
	
	//添加宠物寻回
	@RequestMapping(value="/petlostAdd")
	public String petlostAdd(Petlost petlost,HttpServletRequest req)throws Exception{
		petlostService.insertPetlost(petlost);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","petlostList.action");
		return "common/succeed.jsp";
	}
	
	//删除宠物寻回
	@RequestMapping(value="/petlostDel")
	public String petlostDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		petlostService.deletePetlost(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","petlostList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/topetlostEdit")
	public String topetlostEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Petlost petlost=petlostService.queryPetlostById(id);
		req.setAttribute("petlost", petlost);

		return "/admin/petlost/petlostEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/topetlostView")
	public String topetlostView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Petlost petlost=petlostService.queryPetlostById(id);

		req.setAttribute("petlost", petlost);
		return "/admin/petlost/petlostView.jsp";
	}

	//修改宠物寻回
	@RequestMapping(value="/petlostEdit")
	public String petlostEdit(Petlost petlost,HttpServletRequest req)throws Exception{
		Petlost po=petlostService.queryPetlostById(petlost.getId());

		petlostService.updatePetlost(petlost);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","petlostList.action");
		return "common/succeed.jsp";
	}



	
}
