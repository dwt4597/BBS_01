package com.biz.bbs.dao;

import java.sql.*;
import java.util.*;

import com.biz.bbs.vo.*;

/*
 * DaoImp
 * 이 클래스는 실질적으로 Dao를 실행할 코드를 작성하는 부분이다.
 * 이 클래스는 반드시 Dao 인터페이스를 상속받도록 해야한다.
 */
public class BBsMainDaoImp implements BBsMainDao {
	
	private Connection dbConn;
	
	public BBsMainDaoImp() {
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
		
		
		// TODO 게시판 데이터를 모두 읽어서 List로 리턴하는 메서드
		/*
		 * JDBC를 통해서 DB와 연동하는 코드를 작서할 때, SQL 관련 문자열들은 
		 * " 와 문자열 시작 및 끝 사이에 반드시 빈칸을 한개 이상
		 * 추가해서 작성하자.
		 */
		String sql = " SELECT * FROM tbl_bbs_main ";

		/*
		 * sql 문자열을 JDBC에 보내는 절차
		 */
		PreparedStatement ps;

		try {
			/*
			 * 문자열로 되어 있는 SQL 명령문을 JDBC가 알 수 있도록 
			 * 변환하는 과정(절차)
			 */
			ps = dbConn.prepareStatement(sql);

			/*
			 * 드디어 DB에게 JDBC를 통해 SQL을 실행하라고 명령
			 * 
			 * 그리고, SQL이 정상적으로 수행이 완료되면 
			 * 그 결과 (SELECT를 실행 했으므로, 그 리스트)를
			 */
			ResultSet rs = ps.executeQuery();
			
			/*
			 * rs에 받아놓은 데이터 리스트를 List에 옮겨 담는다.
			 */
			List<BBsMainVO> bbsList = new ArrayList();
			
			/*
			 * rs에 들어 있는 데이터를 읽겠다. 준비하라
			 * rs.next()
			 * 		한줄을 읽어서 값을 추출할 준비를 하라
			 */
//			while(true) {
//				if(rs.next()==false)break;
			while(rs.next()) {
				/*
				 * rs.next()에 의해서 추출된 한 줄의 데이터에서
				 * 각 칼럼의 값들을 추출해서
				 * 변수에 저장해 둔다.
				 */
				long id = rs.getLong("b_id");
				String strDate = rs.getString("b_date");
				String strAuth = rs.getString("b_auth");
				String strSubject = rs.getString("b_subject");
				String strText = rs.getString("b_text");
				/*
				 * 변수에 저장된 값들을
				 * vo를 만들어서 vo의 member변수에 저장하라.
				 */
				BBsMainVO vo = new BBsMainVO();
				vo.setB_id(id);
				vo.setB_date(strDate);
				vo.setB_auth(strAuth);
				vo.setB_subject(strSubject);
				vo.setB_text(strText);
				/*
				 * 값들이 저자된 vo를 bbsList에 추가해서
				 * list를 만들어라
				 */
				bbsList.add(vo);
			}
			return bbsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
