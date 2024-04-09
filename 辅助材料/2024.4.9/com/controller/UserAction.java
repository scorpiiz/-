package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.service.UserService;

import com.util.PageBean;
import com.util.ComUtil;

@Controller
public class UserAction{
	
	@Autowired
	private UserService userService;


	
	//查询所有用户
	@RequestMapping(value="/userList")
	public String userList(User ser,HttpServletRequest req)throws Exception{
		
		/** 分页代码   **/
		int offset = 0;  //记录偏移量，数据分页用到
		int counts = 0;  //总记录数
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		counts=userService.getCount(ser);
		List<User> userList=userService.queryUserList(ser, page);

		req.setAttribute("userList", userList);
		/** 分页代码  k开始**/
		req.setAttribute("itemSize",counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		req.setAttribute("pageItem",PageBean.PAGE_IETM);
		req.setAttribute("pageTotal",page_count);
		ComUtil.setPageMap(req,((offset/PageBean.PAGE_IETM)+1),page_count);
		/** 分页代码  结束 **/
		return "/admin/user/userList.jsp";
	}

	//跳转到添加页面
	@RequestMapping(value="/userToAdd")
	public String userToAdd(HttpServletRequest req)throws Exception{

		return "/admin/user/userAdd.jsp";
	}
	
	//添加用户
	@RequestMapping(value="/userAdd")
	public String userAdd(User user,HttpServletRequest req)throws Exception{
		userService.insertUser(user);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","userList.action");
		return "common/succeed.jsp";
	}
	
	//删除用户
	@RequestMapping(value="/userDel")
	public String userDel(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		userService.deleteUser(id);
		req.setAttribute("message","操作成功");
		req.setAttribute("path","userList.action");
		return "common/succeed.jsp";
	}
	
	//跳转到修改页面	
	@RequestMapping(value="/touserEdit")
	public String touserEdit(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		User user=userService.queryUserById(id);
		req.setAttribute("user", user);

		return "/admin/user/userEdit.jsp";
	}

	//跳转到详情页面	
	@RequestMapping(value="/touserView")
	public String touserView(HttpServletRequest req)throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		User user=userService.queryUserById(id);

		req.setAttribute("user", user);
		return "/admin/user/userView.jsp";
	}

	//修改用户
	@RequestMapping(value="/userEdit")
	public String userEdit(User user,HttpServletRequest req)throws Exception{
		User po=userService.queryUserById(user.getId());

		userService.updateUser(user);

		req.setAttribute("message","操作成功");
		req.setAttribute("path","userList.action");
		return "common/succeed.jsp";
	}



	
}
