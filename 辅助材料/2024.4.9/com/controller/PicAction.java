package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Pic;
import com.service.PicService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class PicAction{
	
	@Autowired
	private PicService picService;


	
	//查询所有轮播图
	@RequestMapping(value="/picList")
	public String picList(Pic ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=picService.getCount(ser);
		List<Pic> picList=picService.queryPicList(ser, page);

		req.setAttribute("picList", picList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/pic/picList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/picToAdd")
	public String picToAdd(HttpServletRequest req)throws Exception{

		return "/admin/pic/picAdd.jsp";
	}
	
	//添加轮播图
	@RequestMapping(value="/picAdd")
	public String picAdd(Pic pic,HttpServletRequest req)throws Exception{
		picService.insertPic(pic);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","picList.action");
		return "common/succeed.jsp";
	}
	
	//删除轮播图
	@RequestMapping(value="/picDel")
	public String picDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		picService.deletePic(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","picList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/topicEdit")
	public String topicEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Pic pic=picService.queryPicById(id);
		req.setAttribute("pic", pic);

		return "/admin/pic/picEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/topicView")
	public String topicView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		Pic pic=picService.queryPicById(id);

		req.setAttribute("pic", pic);
		return "/admin/pic/picView.jsp";
	}

	//修改轮播图
	@RequestMapping(value="/picEdit")
	public String picEdit(Pic pic,HttpServletRequest req)throws Exception{
		Pic po=picService.queryPicById(pic.getId());

		picService.updatePic(pic);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","picList.action");
		return "common/succeed.jsp";
	}



	
}
