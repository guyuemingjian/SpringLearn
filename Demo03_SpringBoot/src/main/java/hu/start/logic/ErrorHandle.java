package hu.start.logic;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.start.logicerror.resultException;
import hu.start.mode.Result;

@ControllerAdvice
public class ErrorHandle {

	/**
	 * 捕获异常，返回result格式对象
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = resultException.class)
	@ResponseBody
	public Result<resultException> cathError(resultException e) {

		Result<resultException> result = ResultUtil.error();
		result.setReCode(e.getReCode());
		result.setReMsg(e.getMessage());
		result.setData(e);
		return result;

	}
}
