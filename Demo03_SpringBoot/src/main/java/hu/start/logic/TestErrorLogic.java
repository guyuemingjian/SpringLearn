package hu.start.logic;

import org.springframework.stereotype.Service;

import hu.start.logicerror.resultException;

@Service("terrorlogic")
public class TestErrorLogic {

	/**
	 * 判断业务 16：是最小值 ;>16：可以的
	 * 
	 * @param id
	 * @throws Exception 
	 */
	public void validId(String id) throws Exception {

		if (16 == Integer.valueOf(id)) {
			throw new resultException("16", "是最小值");
		} else if (16 < Integer.valueOf(id) && 18 > Integer.valueOf(id)) {
			throw new resultException("17", "可以的");
		}
	}
}
