package com.controller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.service.AdminService;
import com.model.Admin;

import com.util.ComUtil;
import com.util.DateUtils;
import com.util.PageBean;


@Controller
public class IndexAction {

	@Autowired
	private AdminService   adminService ;


	//列表分页
	private static int PAGESIZE=5;

	@RequestMapping(value="/index")
	public String inddex(HttpServletRequest request)throws Exception{
		return "login.jsp";
	}
	
	@RequestMapping(value="/adminindex")
	public String adminindex(HttpServletRequest request)throws Exception{

		return "admin/index.jsp";

	}

	@RequestMapping(value="/toright")
	public String toright(HttpServletRequest request)throws Exception{

		return "admin/right.jsp";

	}
	
	@RequestMapping(value="/toquit")
	public String toquit(HttpServletRequest request)throws Exception{

		return "admin/quit.jsp";

	}
	
	@RequestMapping(value="/webc")
	public String webc(HttpServletRequest request)throws Exception{

		return "admin/wec.jsp";

	}

	@RequestMapping(value="/toadminpass")
	public String toadminpass(HttpServletRequest request)throws Exception{

		return "admin/admin/pass.jsp";

	}

	
	@RequestMapping(value="/toadminlogin")
	public String toadminlogin(HttpServletRequest request) throws Exception {
		return "login.jsp";
	}

	@RequestMapping(value="/adminLogin")
	public String adminLogin(Admin ser,HttpServletRequest request) throws Exception {
		if("".equals(ser.getLname()) || "".equals(ser.getPwd()))
		{
            request.setAttribute("message", "用户名或密码错误");	
		    request.setAttribute("path", "toadminlogin.action");
		}
		else 
		{

			    String role="管理员";
				List<Admin> adminList=adminService.queryAdminList(ser, null);
				if(adminList != null && adminList.size()>0)
				{
					 Admin admin=adminList.get(0);
					 HttpSession session =request.getSession();
					 session.setAttribute("adminId", admin.getAid());
					 session.setAttribute("adminLno", admin.getLname());
					 session.setAttribute("adminLname", admin.getLname());
					 session.setAttribute("role", role);
					 request.setAttribute("message", "登录成功");	
					 request.setAttribute("path", "adminindex.action");
				}
				else
				{
					request.setAttribute("message", role+"用户名或密码错误");	
					request.setAttribute("path", "toadminlogin.action");
				}

		}
		return "common/succeed.jsp";
	}

	@RequestMapping(value="/admin_Pass")
	public String admin_Pass(Admin serr,HttpServletRequest request)throws Exception{
		
		String pass1=request.getParameter("txt_pwd");
		String pass=request.getParameter("txt_pwd2");
		String pass3=request.getParameter("txt_pwd3");
		if(pass1==null || pass==null || "".equals(pass1) || "".equals(pass))
		{
            request.setAttribute("message", "原密码或新密码为空");	
		}
		else if(!pass.equals(pass3))
		{
            request.setAttribute("message", "确认密码和新密码不一致");	
		}
			
		else 
		{
        
			int aid=ComUtil.getLoginAid(request);
			String role=ComUtil.getLoginRole(request);
			if(aid==0)
			{
				request.setAttribute("message", "请重新登录！");	
			}
			else 
			{

					Admin ser =new Admin();
					ser.setAid(aid); 
					ser.setPwd(pass1); 
					List<Admin> adminList=adminService.queryAdminList(ser, null);
					if(adminList != null && adminList.size()>0)
					{
						ser.setPwd(pass); 
						adminService.updateAdmin(ser);
						request.setAttribute("message", "修改成功");	
					}
					else
					{
						request.setAttribute("message", "原密码错误");	
					}

			  }
		}
		request.setAttribute("path","toadminpass.action");
		return "common/succeed.jsp";
	}

        

        @RequestMapping(value="/fileup")
		public String file_Up(HttpServletRequest req,@RequestParam("file")MultipartFile data) throws Exception {
		

        String file_name=data.getOriginalFilename();
        String newFile1Name=new Date().getTime()+file_name.substring(file_name.lastIndexOf("."));
	    //System.out.println("新文件名称1："+newFile1Name);
				
		String saveurl = req.getSession().getServletContext().getRealPath("/upload");
        File targetFile = new File(saveurl,newFile1Name); 
        //把本地文件上传到封装上传文件位置的全路径
        data.transferTo(targetFile);
        String wj="/upload/"+newFile1Name;

        req.setAttribute("wj",wj);	

		return "common/file_cpc.jsp";
	}
	
	
}

