package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.db.dbmanager;
import com.model.menudetail;

public class menudetailDAO {
	private String detail1 = "select md.P_IMG, md.P_NAME from MENUS_DETAIL md where md.CATE = '"; //查找menus_detail信息
	private String detail2 = " order by md.COLL asc";//顺序排序
//	String detail = "select md.P_IMG, md.P_NAME from MENUS_DETAIL md where md.CATE = ?";
	String filedest = "http://122.152.201.74/academus/image";
	String img;
	String name;
	public List<menudetail>  selectdetail(String cate) throws SQLException{
		Connection c = dbmanager.getConnection();
		PreparedStatement ps = c.prepareStatement(detail1+cate+"'"+detail2);
		ResultSet rs = ps.executeQuery();
		List<menudetail> mud = new ArrayList<menudetail>();
		while(rs.next()){
			menudetail md = new menudetail();
			img = rs.getString(1).trim();
			name = rs.getString(2).trim();
			md.setIMG(img);
			md.setCATE(cate);
			md.setNAME(name);
			mud.add(md);
		}
		return mud;//返回mud到menucateDAO中
	}
	
}