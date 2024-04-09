package com.model;

/**
 * (sms)消息实体类
 */
public class Sms  extends ComData{
	
	private static final long serialVersionUID = 821648682153876L;

	private Integer id;     //编号
	private Integer uid;     //说话人编号
	private String uname;     //说话人
	private Integer sid;     //接收人编号
	private String sname;     //接收人
	private String cont;     //内容
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
