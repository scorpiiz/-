package com.model;

/**
 * (apply)申请记录实体类
 */
public class Apply  extends ComData{
	
	private static final long serialVersionUID = 264151661172611L;

	private Integer id;     //编号
	private Integer uid;     //用户编号
	private String uname;     //用户
	private Integer cid;     //领养编号
	private String cname;     //领养名称
	private String pname;     //领养宠物
	private String cont;     //申请理由
	private String zt;     //状态
	private String addtime;     //申请时间


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


	public Integer getCid() {
	    return cid;
	}

	public void setCid(Integer cid) {
	    this.cid = cid;
	}


	public String getCname() {
	    return cname;
	}

	public void setCname(String cname) {
	    this.cname = cname;
	}


	public String getPname() {
	    return pname;
	}

	public void setPname(String pname) {
	    this.pname = pname;
	}


	public String getCont() {
	    return cont;
	}

	public void setCont(String cont) {
	    this.cont = cont;
	}


	public String getZt() {
	    return zt;
	}

	public void setZt(String zt) {
	    this.zt = zt;
	}


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
