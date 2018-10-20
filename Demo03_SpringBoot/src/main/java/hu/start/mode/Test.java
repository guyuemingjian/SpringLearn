package hu.start.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

/**
 * 
 * @Describe:</br>
 * 				test表的对象</br>
 * 
 * @Null 限制只能为null
 * @NotNull 限制必须不为null
 * @AssertFalse 限制必须为false
 * @AssertTrue 限制必须为true
 * @DecimalMax(value) 限制必须为一个不大于指定值的数字
 * @DecimalMin(value) 限制必须为一个不小于指定值的数字
 * @Digits(integer,fraction) 限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction
 * @Future 限制必须是一个将来的日期
 * @Max(value) 限制必须为一个不大于指定值的数字
 * @Min(value) 限制必须为一个不小于指定值的数字
 * @Pattern(value) 限制必须符合指定的正则表达式
 * @Size(max,min) 限制字符长度必须在min到max之间
 * @Past 验证注解的元素值（日期类型）比当前时间早
 * @NotEmpty 验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0）
 * @NotBlank 验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
 * @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
 * 
 * @author hu</br>
 * @CreateBy:2018年10月13日</br>
 *
 */
@Entity
@Table(name = "select_test") // 对应表名
public class Test {
	@Id // 主键
	@Column(name = "c1") // 对应表的列名
	@Min(value = 26, message = "比26还小了，不行不行") //参数验证
	private String c1;// 主键

	@Column(name = "c2")
	private String c2;

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	@Override
	public String toString() {
		return "Test [c1=" + c1 + ", c2=" + c2 + "]";
	}

}
