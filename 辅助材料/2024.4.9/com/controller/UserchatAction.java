package com.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.model.ResData;
import com.service.UserService;
import com.model.User;
import com.util.ComUtil;
import com.util.DateUtils;
import com.util.PageBean;



@Controller
@ResponseBody
public class UserchatAction {

	@Autowired
	private UserService   userService ;

	@RequestMapping(value="/user_Edit")
    public ResData useredit(User user,HttpServletRequest req)throws Exception{
		ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="操作成功";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
			int uid= u.getId();
            //User user=userService.queryUserById(id);
			String f=req.getParameter("f");
			user.setId(uid);
			if(f.equals("1")) //修改信息
			{
			   userService.updateUser(user);
			}
			else if(f.equals("2")) //修改密码
			{
			  String pass1 = req.getParameter("upass1");
			  User ser = new User();
			  ser.setId(uid);
			  ser.setUpass(pass1);
			
			    List<User> list = userService.queryUserList(ser, null);
			
				if(list!=null&&list.size()>0){
				   userService.updateUser(user);
				}
				else 
				{
				  t=1;
				  msg="原始密码错误";
				}
			}
			else
			{
			   userService.updateUser(user);
			}
			userService.updateUser(user);
			msg="操作成功";
		    //res.setAttribute("path","tomember.action");
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	 }
	
	public User getLogin(HttpServletRequest req) throws Exception {
		int uid=Integer.parseInt(req.getParameter("uuid"));
		if(uid>0)
		{
			return userService.queryUserById(uid);
		}
		return null;
	}
	
	@RequestMapping(value="/user_List")
	public ResData userlist(HttpServletRequest req)throws Exception{
		ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="操作成功";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
			int uid= u.getId();
            User user=userService.queryUserById(uid);
			msg=user.getPic();
			res.setData2(ComUtil.dealpic(req, user.getPic()));
            user.setPic(ComUtil.dpic(req, user.getPic()));

		res.setData(user);
		}
		res.setMsg(msg);
		return res;
	}
	
	//用户登陆
		@RequestMapping(value="/user_Login")
		public ResData user_Login(User user,HttpServletRequest request)throws Exception{
			 ResData res= new ResData();
			int t=0;
			String msg="";
			List<User> list = userService.queryUserList(user, null);
			String lname="";
			int uid=0;
			String tip="";
			if(list!=null&&list.size()>0){
		        
				 User model=list.get(0);
			     msg="登陆成功";
				 tip=model.getMan();
				 //model.setPic(ComUtil.dpic(request, model.getPic()));
				 res.setData(model);
				 res.setUuid(model.getId());
			}
			else 
			{
				  t=1;
	              msg="用户名或密码错误";
			}
	       
			res.setCode(t);
			res.setMsg(msg);
			res.setTip(tip);
			return res;
		}
	    
		//用户注册
		@RequestMapping(value="/user_Add")
		public ResData user_Add(User user,HttpServletRequest request)throws Exception{
			
			//String lname = request.getParameter("uuname");
			int t=0;
			String msg="";
			User ser = new User();
			ser.setUname(user.getUname());
			List<User> list = userService.queryUserList(ser, null);
			if(list!=null&&list.size()>0){
		       	t=1;
	            msg="用户名已存在";
			}
			else 
			{
				userService.insertUser(user);
			}
	        ResData res= new ResData();
			res.setCode(t);
			res.setMsg(msg);
			return res;
		}



}
