package com.model;

/**
 * (photo)社区图片实体类
 */
public class PicData implements java.io.Serializable{
	
	private static final long serialVersionUID = 581558674856785L;

	private Integer id;     //编号
	private String url;     //
	private String pic;     //图片
 

	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}


	public String getUrl() {
	    return url;
	}

	public void setUrl(String url) {
	    this.url = url;
	}


	public String getPic() {
	    return pic;
	}

	public void setPic(String pic) {
	    this.pic = pic;
	}



}

