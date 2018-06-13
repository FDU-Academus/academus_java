package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import com.db.dbmanager;
import com.model.menucate;

public class menucateDAO {
	 private String menucate = "select mc.ID, mc.BANNER,mc.PICTURE, mc.CATE from MENUS_CATE mc order by mc.coll asc"; //���Ҳ˵��Ҳ��б������Ϣ
	 Statement ps = null;
	 ResultSet rs = null;
	 String ID;
	 String BANNER;
	 String CATE;
	 String PICTURE;
	 List DETAIL;
	 public List<menucate> selectmenucate() throws SQLException{
		 Connection c = dbmanager.getConnection();
		 ps = c.createStatement();
		 rs = ps.executeQuery(menucate);
		 List<menucate> muc = new ArrayList<menucate>();
		 while (rs.next()){
			 menucate mc = new menucate();
			 menudetailDAO md = new menudetailDAO();
			 ID = rs.getString(1).trim();
			 BANNER = rs.getString(2).trim();
			 PICTURE = rs.getString(3).trim();
			 CATE = rs.getString(4).trim();
			 DETAIL = md.selectdetail(ID);//��menudetailDAO�ķ�����Ϣmud����detail�У��γɶ����б�
			 mc.setID(ID);
			 mc.setBANNER(BANNER);
			 mc.setCATE(CATE);
			 mc.setPICTURE(PICTURE);
			 mc.setDETAIL(DETAIL);		 
			 muc.add(mc);
		 }

		 return muc;
	 }
	}