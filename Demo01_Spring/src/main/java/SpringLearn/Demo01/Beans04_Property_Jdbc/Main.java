package SpringLearn.Demo01.Beans04_Property_Jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("beans04Config.xml");
		DataSource dSource = (DataSource) aContext.getBean("datasource");

		Connection connection = dSource.getConnection();
		Statement cour = connection.createStatement();
		ResultSet set = cour.executeQuery("select * from select_test;");

		while (set.next()) {
			System.out.println(set.getString("c1"));
			System.out.println(set.getString("c2"));
		}

		set.close();
		cour.close();
		connection.close();

		aContext.close();

//		System.out.println(dSource.getConnection());
	}
}
