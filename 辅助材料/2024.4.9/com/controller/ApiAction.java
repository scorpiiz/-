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
public class ApiAction {

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


	
	
    @RequestMapping(value="/adopt_List")
	public ResData adoptlist(Adopt ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("1")) //首页
		{
           List<Adopt> list=adoptService.queryAdoptList(ser, new PageBean(0,4));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

           List<Pic> list2=picService.queryPicList(null, new PageBean(0,5));
		   list2.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData2(list2);

           List<Petlost> list3=petlostService.queryPetlostList(null, new PageBean(0,3));
		   list3.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData3(list3);

           List<Zixun> list4=zixunService.queryZixunList(null, new PageBean(0,3));
		   list4.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData4(list4);

           Help help= new Help();
           help.setCondition("(zt='进行中' or zt='已结束')");
           List<Help> list5=helpService.queryHelpList(help, new PageBean(0,3));
		   list5.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData5(list5);

		}
        else if(f.equals("2")) //列表页面
		{
           List<Adopt> list=adoptService.queryAdoptList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}
        else if(f.equals("3")) //详细页面
		{
           int id = Integer.parseInt(req.getParameter("id"));

           Adopt sers = new Adopt();
           sers.setSee(1);
           sers.setId(id);
           adoptService.updateAdopt(sers);

           Adopt item= adoptService.queryAdoptById(id);
           item.setPic(ComUtil.dpic(req, item.getPic()));
           res.setData(item);

           Apply sera= new Apply();
		   sera.setCid(id);
           List<Apply> list=applyService.queryApplyList(sera, new PageBean(0,50));
		   list.forEach(p->p.setUserpic(ComUtil.dpic(req, p.getUserpic())));
           res.setData2(list);

		}
        else if(f.equals("4")) //我的发布
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Adopt> list=adoptService.queryAdoptList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}
        else if(f.equals("6")) //我的领养
		{
		   int uid=ComUtil.getLoginuid(req);
           ser.setSid(uid);
           List<Adopt> list=adoptService.queryAdoptList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);
		}

		return res;
	}

    @RequestMapping(value="/apply_List")
	public ResData applylist(Apply ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("4")) //我的页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Apply> list=applyService.queryApplyList(ser, new PageBean(0,50));
           res.setData(list);

		}

		return res;
	}

    @RequestMapping(value="/petlost_List")
	public ResData petlostlist(Petlost ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("2")) //列表页面
		{
           List<Petlost> list=petlostService.queryPetlostList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}
        else if(f.equals("3")) //详细页面
		{
           int id = Integer.parseInt(req.getParameter("id"));

           Petlost sers = new Petlost();
           sers.setSee(1);
           sers.setId(id);
           petlostService.updatePetlost(sers);

           Petlost item= petlostService.queryPetlostById(id);
           item.setPic(ComUtil.dpic(req, item.getPic()));
           res.setData(item);

           Petfind serp= new Petfind();
		   serp.setCid(id);
           List<Petfind> list=petfindService.queryPetfindList(serp, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData2(list);
           int total=0;
		   int uid=Integer.parseInt(req.getParameter("uuid"));
		   if(uid>0)
			{
               total=list.stream().filter(it -> it.getUid()==uid).count()>0?1:0;
			}
           res.setTotal(total);

		}
        else if(f.equals("4")) //列表页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Petlost> list=petlostService.queryPetlostList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}

		return res;
	}

    @RequestMapping(value="/petfind_List")
	public ResData petfindlist(Petfind ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("4")) //我的页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Petfind> list=petfindService.queryPetfindList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}

		return res;
	}

    @RequestMapping(value="/zixun_List")
	public ResData zixunlist(Zixun ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("2")) //列表页面
		{
           List<Zixun> list=zixunService.queryZixunList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}
        else if(f.equals("3")) //详细页面
		{
           int id = Integer.parseInt(req.getParameter("id"));

           Zixun sers = new Zixun();
           sers.setSee(1);
           sers.setId(id);
           zixunService.updateZixun(sers);

           Zixun item= zixunService.queryZixunById(id);
           item.setPic(ComUtil.dpic(req, item.getPic()));
           res.setData(item);



		}
		else if(f.equals("4")) //我的页面
		{
		   int uid=ComUtil.getLoginuid(req);
		   ser.setCondition("id in (select cid from fav where uid="+uid+")");
           List<Zixun> list=zixunService.queryZixunList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}

		return res;
	}

    @RequestMapping(value="/help_List")
	public ResData helplist(Help ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("2")) //列表页面
		{
           ser.setCondition("(zt='进行中' or zt='已结束')");
           List<Help> list=helpService.queryHelpList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);
		}
        else if(f.equals("3")) //详细页面
		{
           int id = Integer.parseInt(req.getParameter("id"));

           Help sers = new Help();
           sers.setSee(1);
           sers.setId(id);
           helpService.updateHelp(sers);

           Help item= helpService.queryHelpById(id);
           item.setPic(ComUtil.dpic(req, item.getPic()));
		   item.setUserpic(ComUtil.dpic(req, item.getUserpic()));
           res.setData(item);

		   Baoming serb= new Baoming();
		   serb.setCid(id);
		   List<Baoming> list=baomingService.queryBaomingList(serb, new PageBean(0,50));
		   list.forEach(p->p.setUserpic(ComUtil.dpic(req, p.getUserpic())));
           res.setData3(list);

           Record serr= new Record();
		   serr.setCid(id);
		   List<Record> list2=recordService.queryRecordList(serr, new PageBean(0,50));
           res.setData2(list2);

		}
        else if(f.equals("4")) //我的页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Help> list=helpService.queryHelpList(ser, new PageBean(0,50));
           list.forEach(p->p.setPic(ComUtil.dpic(req, p.getPic())));
           res.setData(list);

		}

		return res;
	}

    @RequestMapping(value="/baoming_List")
	public ResData baominglist(Baoming ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("4")) //我的页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Baoming> list=baomingService.queryBaomingList(ser, new PageBean(0,50));
           res.setData(list);

		}

		return res;
	}

    @RequestMapping(value="/record_List")
	public ResData recordlist(Record ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("4")) //我的页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Record> list=recordService.queryRecordList(ser, new PageBean(0,50));
           res.setData(list);

		}

		return res;
	}



    @RequestMapping(value="/sms_List")
	public ResData smslist(Sms ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("4")) //我的页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setSid(uid);
           List<Sms> list=smsService.querySmsList(ser, new PageBean(0,50));
           res.setData(list);

		}

		return res;
	}


    @RequestMapping(value="/fav_List")
	public ResData favlist(Fav ser,HttpServletRequest req) throws Exception{
        ResData res= new ResData();
        String f = req.getParameter("f");
        if(f.equals("4")) //我的页面
		{
           int uid=ComUtil.getLoginuid(req);
           ser.setUid(uid);
           List<Fav> list=favService.queryFavList(ser, new PageBean(0,50));
           list.forEach(p->p.setCppic(ComUtil.dpic(req, p.getCppic())));
           res.setData(list);
		}
		return res;
	}



	
	
}

