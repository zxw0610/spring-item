package dao.prototype;

import java.util.List;

import entity.Account;

public interface IAccountDao {
	
	//查询账号
	Account find(int id);
	void saveOrUpdate(Account act);
	void delete(int id);
	List<Account> findAll ();
	List<Account> find(int offset, int pageSize); //-- 0 , int的最大值 Integer.MaxValue
//	Pager<Account> findPaged(int offset, int pageSize);
	int totalItem();//-- 总数
	//-- 再写修改方法
	//void modify(Account act);
	  //--修改账户的方法   
	//void modify(Account act, Connection con);
	//--这么返回的数据，但是我门要做分页光数据是不够的
	
	
	
	
	
	
	
}
