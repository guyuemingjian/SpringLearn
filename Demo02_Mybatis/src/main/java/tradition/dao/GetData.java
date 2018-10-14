package tradition.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tradition.dao.beans.Test;

/**
 * 
 * @Describe:</br>
 * 				取得数据</br>
 *
 * @author Administrator</br>
 * @CreateBy:2018年10月13日</br>
 *
 */
public class GetData {
	private String driverClass = "com.mysql.cj.jdbc.Driver";
	private String user = "root";
	private String password = "root";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";

	private Connection conn = null;
	private PreparedStatement st = null;

	/**
	 * 连接数据库
	 */
	private void getConnect() {
		try {
			
			//加载驱动
			Class.forName(driverClass);
			//建立连接
			conn = DriverManager.getConnection(jdbcUrl, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 取得全表数据
	 * 
	 * @return List<Test>数据列表
	 */
	public List<Test> getData() {
		try {
			getConnect();

			String sql = "SELECT C1,C2 FROM SELECT_TEST";

			st = conn.prepareStatement(sql);
			ResultSet rSet = st.executeQuery(sql);

			List<Test> tList = new ArrayList<Test>();
			while (rSet.next()) {
				Test test = new Test();
				test.setC1(String.valueOf(rSet.getInt("c1")));
				test.setC2(rSet.getString("c2"));
				tList.add(test);
			}

			rSet.close();
			st.close();
			conn.close();

			return tList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 取得查询数据
	 * 
	 * @return List<Test>数据列表
	 */
	public List<Test> getSearchData(String c1, String c2) {
		try {
			getConnect();

			// sql文做成
			StringBuffer sb = new StringBuffer();
			String sql1 = "SELECT C1,C2 FROM SELECT_TEST WHERE 1=1 ";
			String sql2 = " AND C1 =  ";
			String sql3 = " AND C2 = '";

			sb.append(sql1);

			// 参数
			if (!"".equals(c1)) {
				sb.append(sql2);
				sb.append(c1);
			}
			if (!"".equals(c2)) {
				sb.append(sql3);
				sb.append(c2);
				sb.append("' ");
			}

			System.out.println(sb.toString());
			st = conn.prepareStatement(sb.toString());

			ResultSet rSet = st.executeQuery(sb.toString());

			List<Test> tList = new ArrayList<Test>();
			while (rSet.next()) {
				Test test = new Test();
				test.setC1(String.valueOf(rSet.getInt("C1")));
				test.setC2(rSet.getString("C2"));
				tList.add(test);
			}

			rSet.close();
			st.close();
			conn.close();

			return tList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
