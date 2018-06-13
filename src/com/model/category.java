package com.model;

public class category {
	private String NAME;
	private String ID;
	public category(){}
	
	public category(String NAME, String ID){
		super();
		this.NAME = NAME;
		this.ID = ID;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}


	
	@Override
	public String toString() { //∑µªÿrjson–≈œ¢
		return "{\"NAME\":\"" + NAME + "\",\"ID\":\"" + ID + "\"}";
	}

	
}