package mybatis.dao;

public class AnnotationGetDataImp {

	public String getSearchData(String c1, String c2) {
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
		
		return sb.toString();

	}
}
