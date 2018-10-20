package hu.start.mode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @Describe:</br>
 * 				通过继承JpaRepository 来实现数据库CURD</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月16日</br>
 *
 */
@Repository("testM")
public interface TestMapper extends JpaRepository<Test, String> {

}
