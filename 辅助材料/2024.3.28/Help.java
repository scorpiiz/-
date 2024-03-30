package com.model;

/**
 * (help)活动实体类
 */
public class Help  extends ComData{
	
	private static final long serialVersionUID = 886417851465666L;

	private Integer id;     //编号
	private String pname;     //活动主题
	private Integer uid;     //用户编号
	private String uname;     //用户
	private String pic;     //图片
	private Integer see;     //查看
	private String zt;     //状态
	private String man;     //发布人
	private String tel;     //电话
	private String cont;     //活动内容
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


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
