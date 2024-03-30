package com.model;

/**
 * (admin)管理员实体类
 */
public class Admin  extends ComData{
	
	private static final long serialVersionUID = 785741253513562L;

	private Integer aid;     //管理员编号
	private String lname;     //用户名
	private String pwd;     //密码
	private Integer flag;     //标识


	public Integer getAid() {
	    return aid;
	}

	public void setAid(Integer aid) {
	    this.aid = aid;
	}


	public String getLname() {
	    return lname;
	}

	public void setLname(String lname) {
	    this.lname = lname;
	}


	public String getPwd() {
	    return pwd;
	}

	public void setPwd(String pwd) {
	    this.pwd = pwd;
	}


	public Integer getFlag() {
	    return flag;
	}

	public void setFlag(Integer flag) {
	    this.flag = flag;
	}



	
	
}
