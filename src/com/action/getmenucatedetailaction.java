package com.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.DAO.menucateDAO;
import com.opensymphony.xwork2.ActionSupport;

public class getmenucatedetailaction extends ActionSupport {
	private List mucd;

	public List getmucd() {
		return mucd;
	}

	public void setmucd(List mucd) {
		this.mucd = mucd;
	}

	public String execute() throws IOException, SQLException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text");
		menucateDAO md = new menucateDAO();
		this.mucd = md.selectmenucate();
		return "mucd";
	}
}