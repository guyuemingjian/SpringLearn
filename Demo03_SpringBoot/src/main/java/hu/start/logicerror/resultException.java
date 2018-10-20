package hu.start.logicerror;

public class resultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	private String reCode;

	/**
	 * 错误信息
	 */
	private String reMsg;

	public resultException(String reCode, String reMsg) {
		super(reMsg);
		this.reCode = reCode;
	}

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

	@Override
	public String toString() {
		return "resultException [reCode=" + reCode + ", reMsg=" + reMsg + "]";
	}

}
