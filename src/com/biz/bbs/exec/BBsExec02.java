package com.biz.bbs.exec;

import java.util.*;

import com.biz.bbs.dao.*;
import com.biz.bbs.vo.*;

public class BBsExec02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BBsMainDao bm = new BBsMainDaoImp();
//		bm.dbConnection();
		
		/*
		 * BBsMainDao의 selectAll()을 호출(실행)하고
		 * 실행이 완료되면 그(return된) 결과를 받아서
		 * bbsList에 저장하라. 
		 */
		List<BBsMainVO> bbsList = bm.selectAll();
		for(BBsMainVO v : bbsList) {
			System.out.println(v);
		}
		
	}

}
