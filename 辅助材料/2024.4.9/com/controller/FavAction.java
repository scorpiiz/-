package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Fav;
import com.service.FavService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class FavAction{
	
	@Autowired
	private FavService favService;


	
	//查询所有收藏
	@RequestMapping(value="/favList")
	public String favList(Fav ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=favService.getCount(ser);
		List<Fav> favList=favService.queryFavList(ser, page);

		req.setAttribute("favList", favList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/fav/favList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/favToAdd")
	public String favToAdd(HttpServletRequest req)throws Exception{

		return "/admin/fav/favAdd.jsp";
	}
	
	//添加收藏
	@RequestMapping(value="/favAdd")
	public String favAdd(Fav fav,HttpServletRequest req)throws Exception{
		favService.insertFav(fav);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","favList.action");
		return "common/succeed.jsp";
	}
	
	//删除收藏
	@RequestMapping(value="/favDel")
	public String favDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		favService.deleteFav(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","favList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/tofavEdit")
	public String tofavEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Fav fav=favService.queryFavById(id);
		req.setAttribute("fav", fav);

		return "/admin/fav/favEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/tofavView")
	public String tofavView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Fav fav=favService.queryFavById(id);

		req.setAttribute("fav", fav);
		return "/admin/fav/favView.jsp";
	}

	//修改收藏
	@RequestMapping(value="/favEdit")
	public String favEdit(Fav fav,HttpServletRequest req)throws Exception{
		Fav po=favService.queryFavById(fav.getId());

		favService.updateFav(fav);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","favList.action");
		return "common/succeed.jsp";
	}



	
}
