package com.model;

/**
 * (ComData)json实体类
 */
public class ComData implements java.io.Serializable{
	
 	private static final long serialVersionUID = 5918707187629337548L;

	private String sort;  
	private String condition; 
    private Object data;  
	private String cppic;     //产品图片
	private String userpic;     //用户图片
	private String userman;     //用户图片

	public String getSort() {
	    return sort;
	}

	public void setSort(String sort) {
	    this.sort = sort;
	}

	public String getCondition() {
	    return condition;
	}

	public void setCondition(String condition) {
	    this.condition = condition;
	}

	public Object getData() {
	    return data;
	}

	public void setData(Object data) {
	    this.data = data;
	}

	public String getCppic() {
	    return cppic;
	}

	public void setCppic(String cppic) {
	    this.cppic = cppic;
	}

	public String getUserpic() {
	    return userpic;
	}

	public void setUserpic(String userpic) {
	    this.userpic = userpic;
	}

	public String getUserman() {
	    return userman;
	}

	public void setUserman(String userman) {
	    this.userman = userman;
	}
	
}

