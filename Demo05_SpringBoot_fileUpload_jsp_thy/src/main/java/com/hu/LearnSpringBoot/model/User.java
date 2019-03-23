package com.hu.LearnSpringBoot.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {

	/** 姓名 */
	@NotEmpty(message = "姓名不能为空")
	private String name;

	/** 年齡 */
	@Min(value = 18, message = "年龄不能小于18")
	@Max(value = 150, message = "年龄不能大于150")
	private String age;

	/** 密碼 */
	@Length(min = 5, max = 20, message = "密码长度在5~20位之间")
	private String pasw;

	public User() {
		super();
	}

	public User(@NotEmpty(message = "姓名不能为空") String name,
			@Min(value = 18, message = "年龄不能小于18") @Max(value = 150, message = "年龄不能大于150") String age,
			@Length(min = 5, max = 20, message = "密码长度在5~20位之间") String pasw) {
		super();
		this.name = name;
		this.age = age;
		this.pasw = pasw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPasw() {
		return pasw;
	}

	public void setPasw(String pasw) {
		this.pasw = pasw;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", pasw=" + pasw + "]";
	}

}
