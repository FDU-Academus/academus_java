package com.model;

public class menudetail {
	private String P_IMG;
	private String P_NAME;
	private String CATE;
	public menudetail(){}
	
	public menudetail(String P_IMG, String P_NAME){
		super();
		this.P_IMG = P_IMG;
		this.P_NAME = P_NAME;
	}
	
	public String getIMG() {
		return P_IMG;
	}

	public void setIMG(String P_IMG) {
		this.P_IMG = P_IMG;
	}

	public String getNAME() {
		return P_NAME;
	}

	public void setNAME(String P_NAME) {
		this.P_NAME = P_NAME;
	}
	public String getCATE() {
		return CATE;
	}

	public void setCATE(String CATE) {
		this.CATE = CATE;
	}


	
	@Override
	public String toString() { //返回mud内容到menucate中的detail，形成一二级list
		return "{\"IMG\":\"" + P_IMG + "\",\"NAME\":\"" + P_NAME + "\",\"CATE\":\"" + CATE + "\"}";
	}
}
