package com.model;

import java.util.List;

public class menucate {
	private String ID;
	private String BANNER;
	private String CATE;
	private List DETAIL;
	private String PICTURE;
	public menucate(){}
	public menucate(String ID, String BANNER, String CATE) {
		super();
		this.ID = ID;
		this.BANNER = BANNER;
		this.CATE = CATE;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getBANNER() {
		return BANNER;
	}

	public void setBANNER(String BANNER) {
		this.BANNER = BANNER;
	}
	public String getPICTURE() {
		return PICTURE;
	}

	public void setPICTURE(String PICTURE) {
		this.PICTURE = PICTURE;
	}

	public String getCATE() {
		return CATE;
	}

	public void setCATE(String CATE) {
		this.CATE = CATE;
	}
	public List getDETAIL() {
		return DETAIL;
	}

	public void setDETAIL(List DETAIL) {
		this.DETAIL = DETAIL;
	}
	
	@Override
	public String toString() { //·µ»ØrmucÄÚÈÝ
		return "{\"ID\":\"" + ID + "\",\"BANNER\":\"" + BANNER + "\","
				+"\"CATE\":\"" + CATE + "\",\"DETAIL\":\"" + DETAIL +"\","
				+"\"PICTURE\":\"" + PICTURE +"\"}";
	}
}