package hu.start.mode;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @Describe:</br>
 * 				将application.yml内的对应testUser值注入</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月15日</br>
 *
 */

@Component("tU")//在容器中标识为tU
@ConfigurationProperties(prefix = "testuser")//将配置文件的前缀testUser的数据注入进来
public class TestUser {

	String userId;
	String userNm;
	String userPw;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}
