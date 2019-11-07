package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestAppConfig;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;

/**
 * AccountService 测试
 * @author 张泽
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class})
public class AccountServiceTest {
	@Autowired
	private IAccountService actService;
	
	@Test
	public void testSearchAccount() {
		Account act = actService.searchAccount(3);
		System.out.println(act);
	}
	@Test
	public void test01() {
		Pager<Account> pager = (Pager<Account>)actService.listPaged(1, 2);
		for (Account account : pager.getData()) {
			System.out.println(account);
		}
	}
	
}
