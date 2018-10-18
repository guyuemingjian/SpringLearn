package mybatis.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.dao.beans.Test;

public class GetData {

	public List<Test> getData() {

		BaseDao bDao = new BaseDao();
		SqlSession sqlSession = null;
		List<Test> rList = null;
		try {
			// 获得数据库连接
			sqlSession = bDao.getSqlSession();
			// 通过连接执行sql//通过映射名字调用sql(namespace + id)
			rList = sqlSession.selectList("mybatis.dao.TestMapper.getTestMapper");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}

		return rList;
	}

	public List<Test> getAnData() {

		BaseDao bDao = new BaseDao();
		SqlSession sqlSession = null;
		List<Test> rList = null;
		try {
			// 获得数据库连接
			sqlSession = bDao.getSqlSession();
			// 通过连接执行sql//通过映射名字调用sql(namespace + id)
			AnnotationGetData aData = sqlSession.getMapper(AnnotationGetData.class);
			rList = aData.getData();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}

		return rList;
	}

	/**
	 * 取得查询数据
	 * 
	 * @return List<Test>数据列表
	 */
	public List<Test> getAnSearchData(String c1, String c2) {
		BaseDao bDao = new BaseDao();
		SqlSession sqlSession = null;
		List<Test> rList = null;
		try {
			// 获得数据库连接
			sqlSession = bDao.getSqlSession();
			// 通过连接执行sql//通过映射名字调用sql(namespace + id)
			AnnotationGetData aData = sqlSession.getMapper(AnnotationGetData.class);
			rList = aData.getSearchData(c1, c2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}

		return rList;
	}

}
