package com.model;

/**
 * (fav)收藏实体类
 */
public class Fav  extends ComData{
	
	private static final long serialVersionUID = 752425726852312L;

	private Integer id;     //编号
	private Integer uid;     //用户编号
	private String uname;     //用户
	private Integer cid;     //知识编号
	private String cname;     //知识名称
	private String addtime;     //收藏时间


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


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
