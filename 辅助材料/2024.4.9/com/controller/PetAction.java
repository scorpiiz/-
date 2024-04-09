package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Pet;
import com.service.PetService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class PetAction{
	
	@Autowired
	private PetService petService;


	
	//查询所有我的宠物
	@RequestMapping(value="/petList")
	public String petList(Pet ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=petService.getCount(ser);
		List<Pet> petList=petService.queryPetList(ser, page);

		req.setAttribute("petList", petList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/pet/petList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/petToAdd")
	public String petToAdd(HttpServletRequest req)throws Exception{

		return "/admin/pet/petAdd.jsp";
	}
	
	//添加我的宠物
	@RequestMapping(value="/petAdd")
	public String petAdd(Pet pet,HttpServletRequest req)throws Exception{
		petService.insertPet(pet);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","petList.action");
		return "common/succeed.jsp";
	}
	
	//删除我的宠物
	@RequestMapping(value="/petDel")
	public String petDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		petService.deletePet(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","petList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/topetEdit")
	public String topetEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Pet pet=petService.queryPetById(id);
		req.setAttribute("pet", pet);

		return "/admin/pet/petEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/topetView")
	public String topetView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Pet pet=petService.queryPetById(id);

		req.setAttribute("pet", pet);
		return "/admin/pet/petView.jsp";
	}

	//修改我的宠物
	@RequestMapping(value="/petEdit")
	public String petEdit(Pet pet,HttpServletRequest req)throws Exception{
		Pet po=petService.queryPetById(pet.getId());

		petService.updatePet(pet);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","petList.action");
		return "common/succeed.jsp";
	}



	
}
