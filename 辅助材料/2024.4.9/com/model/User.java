package com.model;

/**
 * (user)用户实体类
 */
public class User  extends ComData{
	
	private static final long serialVersionUID = 433527562632426L;

	private Integer id;     //编号
	private String uname;     //用户名
	private String upass;     //密码
	private String pic;     //头像
	private String man;     //姓名
	private String tel;     //电话
	private String address;     //地址
	private String addtime;     //注册时间


	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}


	public String getUname() {
	    return uname;
	}

	public void setUname(String uname) {
	    this.uname = uname;
	}


	public String getUpass() {
	    return upass;
	}

	public void setUpass(String upass) {
	    this.upass = upass;
	}


	public String getPic() {
	    return pic;
	}

	public void setPic(String pic) {
	    this.pic = pic;
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


	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
