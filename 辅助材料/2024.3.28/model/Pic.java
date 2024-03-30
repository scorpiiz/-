package com.model;

/**
 * (pic)轮播图实体类
 */
public class Pic  extends ComData{
	
	private static final long serialVersionUID = 436314851556545L;

	private Integer id;     //编号
	private String bt;     //名称
	private String pic;     //图片


	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}


	public String getBt() {
	    return bt;
	}

	public void setBt(String bt) {
	    this.bt = bt;
	}


	public String getPic() {
	    return pic;
	}

	public void setPic(String pic) {
	    this.pic = pic;
	}



	
	
}
