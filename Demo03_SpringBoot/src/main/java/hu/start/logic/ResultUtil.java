package hu.start.logic;

import hu.start.mode.Result;

/**
 * 
 * @Describe:</br>
 * 				返回信息的处理</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月19日</br>
 *
 */
public class ResultUtil {

	/**
	 * 正常结束 返回信息
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data) {
		Result<T> result = new Result<>();
		result.setReCode("0");
		result.setReMsg("正常完了");
		result.setData(data);
		return result;
	}
	
	/**
	 * 异常结束 返回信息
	 * @param data
	 * @return
	 */
	public static <T> Result<T> error() {
		Result<T> result = new Result<>();
		result.setReCode("1");
		return result;
	}
}
