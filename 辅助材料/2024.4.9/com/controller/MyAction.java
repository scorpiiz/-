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

import com.service.AdminService;
import com.model.Admin;
import com.service.UserService;
import com.model.User;
import com.service.AdoptService;
import com.model.Adopt;
import com.service.ApplyService;
import com.model.Apply;
import com.service.PetlostService;
import com.model.Petlost;
import com.service.PetfindService;
import com.model.Petfind;
import com.service.ZixunService;
import com.model.Zixun;
import com.service.HelpService;
import com.model.Help;
import com.service.BaomingService;
import com.model.Baoming;
import com.service.RecordService;
import com.model.Record;
import com.service.PetService;
import com.model.Pet;
import com.service.SmsService;
import com.model.Sms;
import com.service.PicService;
import com.model.Pic;
import com.service.FavService;
import com.model.Fav;


import com.model.ResData;
import com.util.ComUtil;
import com.util.DateUtils;
import com.util.PageBean;


@Controller
@ResponseBody
public class MyAction {
	

	@Autowired
	private AdminService   adminService ;

	@Autowired
	private UserService   userService ;

	@Autowired
	private AdoptService   adoptService ;

	@Autowired
	private ApplyService   applyService ;

	@Autowired
	private PetlostService   petlostService ;

	@Autowired
	private PetfindService   petfindService ;

	@Autowired
	private ZixunService   zixunService ;

	@Autowired
	private HelpService   helpService ;

	@Autowired
	private BaomingService   baomingService ;

	@Autowired
	private RecordService   recordService ;

	@Autowired
	private PetService   petService ;

	@Autowired
	private SmsService   smsService ;

	@Autowired
	private PicService   picService ;

	@Autowired
	private FavService   favService ;



	
    @RequestMapping(value="/adopt_Add")
	public ResData adoptadd(Adopt adopt,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="发布失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();
		    adopt.setUid(u.getId());
            adopt.setUname(u.getMan());
		    adoptService.insertAdopt(adopt);
			msg="发布成功";
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/adopt_Edit")
	public ResData adoptEdit(Adopt adopt,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="修改失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
			int uid = u.getId();
		    adoptService.updateAdopt(adopt);
			msg="操作成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	@RequestMapping(value="/adote_Del")
	public ResData adotedel(HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="删除失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
            int id  = Integer.parseInt(req.getParameter("id"));
			int uid = u.getId();
		    adoptService.deleteAdopt(id);
			msg="删除成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/apply_Add")
	public ResData applyadd(Apply apply,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="申请失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();
		    
		    apply.setUid(u.getId());
            apply.setUname(u.getMan());
		    applyService.insertApply(apply);
			msg="申请成功，请等待管理员审核";
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	@RequestMapping(value="/apply_Del")
	public ResData applydel(HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="删除失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
            int id  = Integer.parseInt(req.getParameter("id"));
			int uid = u.getId();
		    applyService.deleteApply(id);
			msg="删除成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}


    @RequestMapping(value="/petlost_Add")
	public ResData petlostadd(Petlost petlost,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="发布失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();
		    petlost.setUid(u.getId());
            petlost.setUname(u.getMan());
		    petlostService.insertPetlost(petlost);
			msg="发布成功";
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	@RequestMapping(value="/petlost_Del")
	public ResData petlostdel(HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="删除失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
            int id  = Integer.parseInt(req.getParameter("id"));
			int uid = u.getId();
		    petlostService.deletePetlost(id);
			msg="删除成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/petfind_Add")
	public ResData petfindadd(Petfind petfind,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="上传凭证失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();
		    petfind.setUid(u.getId());
            petfind.setUname(u.getMan());
		    petfindService.insertPetfind(petfind);
			msg="上传凭证成功，请与失主联系";
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/petfind_Edit")
	public ResData petfindEdit(Petfind petfind,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="修改失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
			int uid = u.getId();
		    petfindService.updatePetfind(petfind);
			if(petfind.getZt().equals("寻回成功")){
			    Petlost petlost= new Petlost();
				petlost.setId(petfind.getCid());
				petlost.setZt("寻回成功");
			    petlostService.updatePetlost(petlost);
			}

		  Petfind po=petfindService.queryPetfindById(petfind.getId());

          addsms(3,"寻回确认消息",po.getUid(),po.getUname(),"你上传的寻回凭证被确认会"+petfind.getZt());

		  msg="操作成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	@RequestMapping(value="/petfind_Del")
	public ResData petfinddel(HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="删除失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
            int id  = Integer.parseInt(req.getParameter("id"));
			int uid = u.getId();
		    petfindService.deletePetfind(id);
			msg="删除成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/help_Add")
	public ResData helpadd(Help help,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="发布活动失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();
		    help.setUid(u.getId());
            help.setUname(u.getMan());
		    helpService.insertHelp(help);
			msg="发布活动成功，请等待管理员审核";
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/help_Edit")
	public ResData helpEdit(Help help,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="修改失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
			int uid = u.getId();
		    helpService.updateHelp(help);
			if(help.getZt().equals("已完结")){

			   Baoming serb= new Baoming();
			   serb.setCid(help.getId());
			   serb.setZt("已通过");
			   Baoming baoming= new Baoming();

			   Help po=helpService.queryHelpById(help.getId());
			   List<Baoming> list=baomingService.queryBaomingList(serb, new PageBean(0,50));
			   list.forEach(p->{

					baoming.setId(p.getId());
					baoming.setZt("已完结");
					try {
						baomingService.updateBaoming(baoming);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						addsms(2,"活动完结消息",p.getUid(),p.getUname(),"你报名成功的"+po.getPname()+"已完结。");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			   });


			}
			msg="操作成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	@RequestMapping(value="/help_Del")
	public ResData helpdel(HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="删除失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
            int id  = Integer.parseInt(req.getParameter("id"));
			int uid = u.getId();
		    helpService.deleteHelp(id);
			msg="删除成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/baoming_Add")
	public ResData baomingadd(Baoming baoming,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="活动报名失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();
		    baoming.setUid(u.getId());
            baoming.setUname(u.getMan());
		    baomingService.insertBaoming(baoming);
			msg="活动报名成功，请等待管理员审核";
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	@RequestMapping(value="/baoming_Del")
	public ResData baomingdel(HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="删除失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
            int id  = Integer.parseInt(req.getParameter("id"));
			int uid = u.getId();
		    baomingService.deleteBaoming(id);
			msg="删除成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/record_Add")
	public ResData recordadd(Record record,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="活动打卡失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();
		    record.setUid(u.getId());
            record.setUname(u.getMan());
		    recordService.insertRecord(record);

            Help po=helpService.queryHelpById(record.getCid());

		    addsms(2,"活动打卡消息",po.getUid(),po.getUname(),"你发布的活动"+po.getPname()+"有新的用户打卡。");

			msg="活动打卡成功";
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

    @RequestMapping(value="/fav_Add")
	public ResData favadd(Fav fav,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="收藏失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{
		    int uid = u.getId();

            int cid  = Integer.parseInt(req.getParameter("cid"));
            Fav ser = new Fav();
			ser.setUid(uid);
			ser.setCid(cid);
			int count=favService.getCount(fav);
			if(count>0){
				t=1;
				   msg="你已经收藏过该知识，请勿重复收藏！";
			}
			else {
		    fav.setUid(u.getId());
            fav.setUname(u.getMan());
		    favService.insertFav(fav);
			msg="收藏成功";
			
			Zixun sers = new Zixun();
	           sers.setFav(1);
	           sers.setId(cid);
	           zixunService.updateZixun(sers);
			}
	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	@RequestMapping(value="/fav_Del")
	public ResData favdel(HttpServletRequest req) throws Exception{
        ResData res= new ResData();
		User u= getLogin(req);
		int t=0;
		String msg="删除失败";
		if(u==null)
		{
           t=1;
		   msg="请先登录";
		}
		else 
		{			
			int uid = u.getId();
            int cid  = Integer.parseInt(req.getParameter("cid"));
            Fav ser = new Fav();
			ser.setUid(uid);
			ser.setCid(cid);
			int id=0;
            List<Fav> list=favService.queryFavList(ser, new PageBean(0,50));
			   if(list != null && list.size()>0){
			   id=list.get(0).getId();
			   }
				if(id>0){
				favService.deleteFav(id);
				}
			msg="删除成功";	
	    }
		res.setCode(t);
		res.setMsg(msg);
		return res;
	}

	public void addsms(int uid,String uname,int sid,String sname,String cont) throws Exception {
		Sms sms= new Sms();
		sms.setUid(uid);
		sms.setUname(uname);
		sms.setSid(sid);
		sms.setSname(sname);
		sms.setCont(cont);
		smsService.insertSms(sms);
	}

    public User getLogin(HttpServletRequest req) throws Exception {
		int uid=Integer.parseInt(req.getParameter("uuid"));
		if(uid>0)
		{
			return userService.queryUserById(uid);
		}
		return null;
	}

	
}
