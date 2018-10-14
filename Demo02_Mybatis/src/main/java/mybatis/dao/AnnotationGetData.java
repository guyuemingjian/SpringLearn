package mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import mybatis.dao.beans.Test;

public interface AnnotationGetData {
	
	@Select("SELECT C1,C2 FROM SELECT_TEST")
	public List<Test> getData() ;

	@SelectProvider(type=AnnotationGetDataImp.class,method="getSearchData")
	public List<Test> getSearchData(String c1 , String c2);
	
}
