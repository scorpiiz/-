package com.model;

/**
 * (zixun)宠物知识实体类
 */
public class Zixun  extends ComData{
	
	private static final long serialVersionUID = 758225282373115L;

	private Integer id;     //编号
	private String bt;     //标题
	private Integer see;     //查看
	private Integer fav;     //收藏
	private String pic;     //图片
	private String bz;     //内容
	private String addtime;     //添加时间


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


	public Integer getSee() {
	    return see;
	}

	public void setSee(Integer see) {
	    this.see = see;
	}


	public Integer getFav() {
	    return fav;
	}

	public void setFav(Integer fav) {
	    this.fav = fav;
	}


	public String getPic() {
	    return pic;
	}

	public void setPic(String pic) {
	    this.pic = pic;
	}


	public String getBz() {
	    return bz;
	}

	public void setBz(String bz) {
	    this.bz = bz;
	}


	public String getAddtime() {
	    return addtime;
	}

	public void setAddtime(String addtime) {
	    this.addtime = addtime;
	}



	
	
}
