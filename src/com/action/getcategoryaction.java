package com.action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.DAO.categoryDAO;
public class getcategoryaction extends ActionSupport {
	private List cate;
	public List getcate(){
		return cate;
	}
	public void setcate(List cate){
		this.cate = cate;
	}
public String execute() throws IOException,SQLException{
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		ActionContext context= ActionContext.getContext();		
//		Map mr = (Map)context.get("request");	
		categoryDAO id  = new categoryDAO();
		this.cate = id.selectinfo();
		System.out.println(cate);
		return "cate";
	}
}
