package service.prototype;

import java.util.List;

import entity.Account;
import entity.User;
import util.Pager;

/*
 * Account业务接口 
 * @author Administrator
 *
 */
public interface IAccountService {
	//转账
	void transfer(Account from,Account to,double money);
		
	//查询账号
	Account searchAccount(int id);
		
	//分页查询账号信息
	List<Account>listAccounts(int pageNo,int pageSize);
	List<Account>listPaged(int pageNo,int pageSize);

	Pager<User> listUsers(int i, int j);
}
