package hu.start.mode;

/**
 * 
 * @Describe:</br>
 * 				用来返回逻辑处理结果</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月19日</br>
 * @param <T>
 *
 */
public class Result<T> {

	/** 返回的状态 */
	private String reCode;
	/** 返回的信息 */
	private String reMsg;
	/** 返回的数据 */
	private T data;

	public String getReCode() {
		return reCode;
	}

	public void setReCode(String reCode) {
		this.reCode = reCode;
	}

	public String getReMsg() {
		return reMsg;
	}

	public void setReMsg(String reMsg) {
		this.reMsg = reMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [reCode=" + reCode + ", reMsg=" + reMsg + ", date=" + data + "]";
	}

}
