package com.controller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.model.PicData;
import com.model.ResData;
import com.util.ComUtil;
import com.util.DateUtils;
import com.util.PageBean;

@Controller
public class FileAction {
	

    @RequestMapping(value="/file_Up")
	@ResponseBody
	public ResData file_Up(HttpServletRequest req,@RequestParam("file")MultipartFile data) throws Exception {
		String f=req.getParameter("f");
        ResData res= new ResData();	
	
		String uid=req.getParameter("uid");
		String uname=req.getParameter("uname");

        String pic=req.getParameter("pic");
		//int pid = Integer.parseInt(req.getParameter("des"));
		//if(pid==0)
		//{
        //   pid = -Integer.parseInt(req.getParameter("uid"));
		//}

        String file_name=data.getOriginalFilename();
        String newFile1Name=new Date().getTime()+file_name.substring(file_name.lastIndexOf("."));
	               //System.out.println("新文件名称1："+newFile1Name);
				
		String saveurl = req.getSession().getServletContext().getRealPath("/upload");
		
        File targetFile = new File(saveurl,newFile1Name); 
        //把本地文件上传到封装上传文件位置的全路径
        data.transferTo(targetFile);
        String wj="/upload/"+newFile1Name;

        //Photo photo =new Photo();
		//photo.setQid(pid);
		//photo.setAddr(wj);
        //photoService.insertPhoto(photo);

        //Photo serr= new Photo();
		//serr.setQid(pid);
		//res.setData(ComUtil.dealurl(req,photoService.queryPhotoList(serr, null)));
		if(!pic.equals(""))
		{
          pic=pic+","+wj;
		}
		else 
		{
          pic=wj;
		}
		res.setMsg(pic);
		res.setData(dealpic(req,pic));
		res.setCode(0);
		return res;
	}

	@RequestMapping(value="/file_Del")
	@ResponseBody
	public ResData file_Del(HttpServletRequest req) throws Exception {
		//int id = Integer.parseInt(req.getParameter("id"));
		//int pid = Integer.parseInt(req.getParameter("qid"));
		//if(pid==0)
		//{
        //   pid = -Integer.parseInt(req.getParameter("uid"));
		//}
		//photoService.deletePhoto(id);
		String pic=req.getParameter("pic");
		String delpic=req.getParameter("delpic");
        pic=(pic+",").replace(delpic+",","");
        ResData res= new ResData();	
        //Photo ser= new Photo();
		//ser.setQid(pid);
		//res.setData(ComUtil.dealurl(req,photoService.queryPhotoList(ser, null)));
		res.setMsg(pic);
		res.setData(dealpic(req,pic));
		res.setCode(0);
		return res;
	}
	
	
	public  List<PicData> dealpic(HttpServletRequest request,String str)
    {
		String url ="";
		url = request.getScheme() +"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath();
		List<PicData> list = new ArrayList<PicData>();
		
		if(str!=null && !str.equals("")){
			String[] arr= str.split(",");
	        String pic="";
			for(int i=0;i<arr.length;i++)
			{
			    if(!arr[i].equals(""))
				{
				   pic=arr[i];
                   PicData model= new PicData();
				   model.setId(i+1);
				   model.setUrl(url+pic);
                   model.setPic(pic);
				   list.add(model);
				}
			}
		}
		return list;
    }

	
	
}

