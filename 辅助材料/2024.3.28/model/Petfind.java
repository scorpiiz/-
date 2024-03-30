package com.model;

/**
 * (petfind)寻回记录实体类
 */
public class Petfind  extends ComData{
	
	private static final long serialVersionUID = 622448472434362L;

	private Integer id;     //编号
	private Integer uid;     //用户编号
	private String uname;     //用户
	private Integer cid;     //寻回编号
	private String cname;     //寻回名称
	private String pic;     //凭证图片
	private String cont;     //描述
	private Float fee;     //寻回奖励
	private String zt;     //状态
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


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
