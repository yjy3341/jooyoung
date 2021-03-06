package kr.co.yjy;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//현재 테스트 코드를 실행할 때 스프링이 로딩되록 하는 애노테이션
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testConection() throws Exception{
		try (Connection con = ds.getConnection()){
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
