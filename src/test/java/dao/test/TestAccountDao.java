package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import config.TestAppConfig;
import dao.prototype.IAccountDao;
import entity.Account;

/**
 * Spring 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class})
public class TestAccountDao {
	@Autowired
	private IAccountDao actDao;
	
	@Test
	public void testFindByID() {
		Account act = actDao.find(2);
		System.out.println(act);
	}
	
	@Test
	public void testDelete() {
		actDao.delete(5);
	}
	
}
