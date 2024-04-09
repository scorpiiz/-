package com.model;

/**
 * (petlost)宠物寻回实体类
 */
public class Petlost  extends ComData{
	
	private static final long serialVersionUID = 542448322718657L;

	private Integer id;     //编号
	private String pname;     //主题
	private Integer uid;     //用户编号
	private String uname;     //用户
	private String pic;     //图片
	private Integer see;     //查看
	private Float fee;     //费用
	private String zt;     //状态
	private String age;     //宠物年龄
	private String address;     //遗失地点
	private String man;     //发布人
	private String tel;     //电话
	private String cont;     //介绍
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


	public Float getFee() {
	    return fee;
	}

	public void setFee(Float fee) {
	    this.fee = fee;
	}


	public String getZt() {
	    return zt;
	}

	public void setZt(String zt) {
	    this.zt = zt;
	}


	public String getAge() {
	    return age;
	}

	public void setAge(String age) {
	    this.age = age;
	}


	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
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
