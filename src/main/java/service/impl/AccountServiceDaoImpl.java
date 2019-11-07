package service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.prototype.IAccountDao;
import entity.Account;
import entity.User;
import service.prototype.IAccountService;
import util.Pager;

/*
 * 业务实现类 
 * 
 */
@Service("accountServiceDaoImpl")
public class AccountServiceDaoImpl implements IAccountService{
	
	//注入
	@Autowired
	private IAccountDao actDao;

	//设计到事务，Spring 声明式的Transaction处理（AOP动态代理模式的应用）
	@Override
	public void transfer(Account from, Account to, double money) {
		
	}

	@Override
	public Account searchAccount(int id) {
		return actDao.find(id);
	}

	@Override
	public List<Account> listAccounts(int pageNo, int pageSize) {
		return actDao.find((pageNo-1)*pageSize,pageSize);
	}

	@Override
	public List<Account> listPaged(int pageNo, int pageSize) {
		return actDao.find((pageNo-1)*pageSize, pageSize);
	}

	@Override
	public Pager<User> listUsers(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
