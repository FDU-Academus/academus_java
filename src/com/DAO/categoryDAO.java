package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.dbmanager;
import com.model.category;

public class categoryDAO {
	private  String info = "select name, id from category";//查找菜单页面左侧导航栏信息
	Statement ps = null;
	ResultSet rs = null;
	String no;
	String dep;
	String sal;
	public List<category>  selectinfo() throws SQLException{
		Connection c = dbmanager.getConnection();
		ps = c.createStatement();
		rs = ps.executeQuery(info);
		List<category> is = new ArrayList<category>();	
        while (rs.next()) {
        	category i = new category();
            no = rs.getString(1).trim();
            dep = rs.getString(2).trim();
            i.setNAME(no);
            i.setID(dep);
            is.add(i);
         }		
		c.close();
		return is;
	}
}