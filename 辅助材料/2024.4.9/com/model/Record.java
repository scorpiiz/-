package com.model;

/**
 * (record)活动打卡实体类
 */
public class Record  extends ComData{
	
	private static final long serialVersionUID = 117867176374276L;

	private Integer id;     //编号
	private Integer uid;     //用户编号
	private String uname;     //用户
	private Integer cid;     //活动编号
	private String cname;     //活动名称
	private String cont;     //打卡内容
	private String addtime;     //打卡时间


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
