package com.model;

/**
 * (pet)我的宠物实体类
 */
public class Pet  extends ComData{
	
	private static final long serialVersionUID = 154611555166632L;

	private Integer id;     //编号
	private Integer uid;     //用户编号
	private String uname;     //用户
	private String pn;     //宠物姓名
	private String pz;     //品种
	private String pic;     //宠物图片
	private String cont;     //介绍
	private String addtime;     //添加时间


	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
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


	public String getPn() {
	    return pn;
	}

	public void setPn(String pn) {
	    this.pn = pn;
	}


	public String getPz() {
	    return pz;
	}

	public void setPz(String pz) {
	    this.pz = pz;
	}


	public String getPic() {
	    return pic;
	}

	public void setPic(String pic) {
	    this.pic = pic;
	}


	public String getCont() {
	    return cont;
	}

	public void setCont(String cont) {
	    this.cont = cont;
	}


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
