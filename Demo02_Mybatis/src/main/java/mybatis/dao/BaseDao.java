package mybatis.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @Describe:</br>
 * 				访问数据库，获取mybatis配置 得到 sqlsessionfactory</br>
 *
 * @author Administrator</br>
 * @CreateBy:2018年10月14日</br>
 *
 */
public class BaseDao {

	public SqlSession getSqlSession() throws IOException {

		String resource = "/mybatisConfig.xml";
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// sqlSession打开会话
		SqlSession session = sessionFactory.openSession();
		return session;
	}
}
