package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import config.TestAppConfig;
import entity.User;
import service.prototype.IAccountService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class})
public class UserServiceTest {
	@Autowired
	private IAccountService userService;
	@Test
	public void findPaged() {
		Pager<User> pager = (Pager<User>) userService.listUsers(2, 2);
		for (User user : pager.getData()) {
			System.out.println(user);
		}
		System.out.println(pager.getTotal());
	}
}
