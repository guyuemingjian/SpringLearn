package mybatis.dao.beans;

/**
 * 
 * @Describe:</br>
 *   test表的对象</br>
 *
 * @author Administrator</br>
 * @CreateBy:2018年10月13日</br>
 *
 */
public class Test {
	private String c1;
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
