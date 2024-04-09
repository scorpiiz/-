package com.util;



import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.model.PicData;



/**
 * 
 * @author Administrator
 *
 */
public class ComUtil {


    //判断是否登录
	public static boolean isLoginAdmin(HttpServletRequest request)
    {
		return isLoginByKey(request,"adminId");
    }

	public static int getLoginAid(HttpServletRequest request)
    {
		return Integer.parseInt(getLoginByKey(request,"adminId"));
    }

	public static String getLoginAName(HttpServletRequest request)
    {
		return  getLoginByKey(request,"adminName");
    }

    public static String getLoginRole(HttpServletRequest request)
    {
		return  getLoginByKey(request,"role");
    }
	
	public static int getLoginuid(HttpServletRequest req)
    {
		return Integer.parseInt(req.getParameter("uuid"));
    }

	public static String getono()
    {
		Random r = new Random();
		int ran1 = r.nextInt(100000);
		String str = String.format("%06d", ran1); 
		return new Date().getTime()+str;
    }


    public static String getUrl(HttpServletRequest request)
    {
       return request.getScheme() +"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath();
	}

	public static  List<PicData> dealpic(HttpServletRequest request,String str)
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

	//更新图片链接
    public static String dpic(HttpServletRequest request,String pic)
    {
		String url =getUrl(request);
		if(pic != null && !pic.equals(""))
		{
		   pic= url+pic;
		}
		return pic;
	}
   

    //判断是否登录
	public static boolean isLoginByKey(HttpServletRequest request,String key)
    {
		HttpSession session=request.getSession();
		if(session !=null && session.getAttribute(key) != null)
		{
			return false;
		}
		else 
		{
			return  true;
		}
    }

    //取出登录编号
	public static String getLoginByKey(HttpServletRequest request,String key)
    {
		HttpSession session=request.getSession();
		if(session !=null && session.getAttribute(key) != null)
		{
			return session.getAttribute(key).toString();
		}
		else 
		{
			return  "0";
		}
    }

    //分页处理
		public static void setPageMap(HttpServletRequest req,int pagenum,int page_count)
	    {
			List<Integer> list= new ArrayList<>();
	        int begin=pagenum>2?(pagenum-2):1;
			int end= (pagenum+2)>page_count?page_count:(pagenum+2);
			if(end<6){ begin=1;}
			for(int i=begin;i<=end;i++)
			{
				list.add(i);
			}
			req.setAttribute("pageList",list);
			req.setAttribute("curPage",pagenum);
	        Map<String, String[]> map = req.getParameterMap();
			String url=req.getRequestURI()+"?_t=0";
				for (String key : map.keySet()) {
					if(key.equals("pager.offset") || key.equals("_t"))
					{

					}
					else 
					{
								String[] values = map.get(key);
								if (values != null) {
								try {
									url+="&"+key+"="+URLEncoder.encode(String.join(",",values),"utf-8");
								} catch (UnsupportedEncodingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	
									}
					}
				}
			req.setAttribute("pUrl",url);	
	    }
	//通过实体更新map
	public static <T> void setModelMap(Map<String, Object> map,T t) 
	{
       if (t != null) {
		   Field[] fields=t.getClass().getDeclaredFields();
	
		for(Field field : fields)
		   {
             field.setAccessible(true);
             try {
				map.put(field.getName(),field.get(t));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		}
	}

}
