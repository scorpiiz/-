package com.model;

/**
 * (adopt)宠物领养实体类
 */
public class Adopt  extends ComData{
	
	private static final long serialVersionUID = 351144727885784L;

	private Integer id;     //编号
	private String pname;     //主题
	private Integer uid;     //用户编号
	private String uname;     //用户
	private String pic;     //图片
	private Integer see;     //查看
	private String zt;     //状态
	private String pz;     //品种
	private String pn;     //宠物姓名
	private String man;     //发布人
	private String tel;     //电话
	private String cont;     //介绍
	private Integer sid;     //领养人编号
	private String sname;     //领养人
	private String addtime;     //添加时间


	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}


	public String getPname() {
	    return pname;
	}

	public void setPname(String pname) {
	    this.pname = pname;
	}


	public Integer getUid() {
	    return uid;
	}

	public void setUid(Integer uid) {
	    this.uid = uid;
	}


	public String getUname() {
	    return uname;
	}

	public void setUname(String uname) {
	    this.uname = uname;
	}


	public String getPic() {
	    return pic;
	}

	public void setPic(String pic) {
	    this.pic = pic;
	}


	public Integer getSee() {
	    return see;
	}

	public void setSee(Integer see) {
	    this.see = see;
	}


	public String getZt() {
	    return zt;
	}

	public void setZt(String zt) {
	    this.zt = zt;
	}


	public String getPz() {
	    return pz;
	}

	public void setPz(String pz) {
	    this.pz = pz;
	}


	public String getPn() {
	    return pn;
	}

	public void setPn(String pn) {
	    this.pn = pn;
	}


	public String getMan() {
	    return man;
	}

	public void setMan(String man) {
	    this.man = man;
	}


	public String getTel() {
	    return tel;
	}

	public void setTel(String tel) {
	    this.tel = tel;
	}


	public String getCont() {
	    return cont;
	}

	public void setCont(String cont) {
	    this.cont = cont;
	}


	public Integer getSid() {
	    return sid;
	}

	public void setSid(Integer sid) {
	    this.sid = sid;
	}


	public String getSname() {
	    return sname;
	}

	public void setSname(String sname) {
	    this.sname = sname;
	}


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
