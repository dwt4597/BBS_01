package com.biz.bbs.dao;

import java.sql.*;
import java.util.*;

import com.biz.bbs.vo.*;

/*
 * DaoImp
 * 이 클래스는 실질적으로 Dao를 실행할 코드를 작성하는 부분이다.
 * 이 클래스는 반드시 Dao 인터페이스를 상속받도록 해야한다.
 */
public class BBsMainDaoImp2 implements BBsMainDao {
	
	private Connection dbConn;
	
	public BBsMainDaoImp2() {
		this.dbConnection();
	}
	
	private void dbConnection() {
		try {

			/*
			 * Driver를 Loading하여 실행
			 */

			/*
			 * DB에 접속할 profile 변수 선언
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "bbsuser";
			String password = "1234";

			dbConn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert(BBsMainVO bbsMainVO) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * selectAll()메서드는
	 * DB로부터 게시판 데이터를 모두 일거서
	 * List로 만들어서 
	 * 호출한 쪽에 다시 return 해준다.
	 */
	@Override
	public List<BBsMainVO> selectAll() {
		String sql = " select * from tbl_bbs_main ";
		PreparedStatement ps;
		
		try {
			ps=dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<BBsMainVO> bbsList = new ArrayList();
			while(rs.next()) {
				long id = rs.getLong("b_id");
				String strDate = rs.getString("b_date");
				String strAuth = rs.getString("b_auth");
				String strSubject = rs.getString("b_subject");
				String strText = rs.getString("b_text");
				
				BBsMainVO vo = new BBsMainVO();
				vo.setB_id(id);
				vo.setB_date(strDate);
				vo.setB_auth(strAuth);
				vo.setB_subject(strSubject);
				vo.setB_text(strText);
				bbsList.add(vo);
				
				
			}
			
			return bbsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void findById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BBsMainVO bbsMainVO) {
		// TODO 여기는 게시판 데이터 업데이트 메서드
		String sql = " UPDATE tbl_bbs_main ";
		sql += " SET b_date = " + " 2018-11-01 ";

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
