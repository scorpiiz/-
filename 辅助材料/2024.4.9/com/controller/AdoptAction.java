package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Adopt;
import com.service.AdoptService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class AdoptAction{
	
	@Autowired
	private AdoptService adoptService;

	
	//查询所有宠物领养
	@RequestMapping(value="/adoptList")
	public String adoptList(Adopt ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=adoptService.getCount(ser);
		List<Adopt> adoptList=adoptService.queryAdoptList(ser, page);

		req.setAttribute("adoptList", adoptList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/adopt/adoptList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/adoptToAdd")
	public String adoptToAdd(HttpServletRequest req)throws Exception{

		return "/admin/adopt/adoptAdd.jsp";
	}
	
	//添加宠物领养
	@RequestMapping(value="/adoptAdd")
	public String adoptAdd(Adopt adopt,HttpServletRequest req)throws Exception{
		adoptService.insertAdopt(adopt);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","adoptList.action");
		return "common/succeed.jsp";
	}
	
	//删除宠物领养
	@RequestMapping(value="/adoptDel")
	public String adoptDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		adoptService.deleteAdopt(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","adoptList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/toadoptEdit")
	public String toadoptEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Adopt adopt=adoptService.queryAdoptById(id);
		req.setAttribute("adopt", adopt);

		return "/admin/adopt/adoptEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/toadoptView")
	public String toadoptView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Adopt adopt=adoptService.queryAdoptById(id);

		req.setAttribute("adopt", adopt);
		return "/admin/adopt/adoptView.jsp";
	}

	//修改宠物领养
	@RequestMapping(value="/adoptEdit")
	public String adoptEdit(Adopt adopt,HttpServletRequest req)throws Exception{
		Adopt po=adoptService.queryAdoptById(adopt.getId());

		adoptService.updateAdopt(adopt);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","adoptList.action");
		return "common/succeed.jsp";
	}



	
}
