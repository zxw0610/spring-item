package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAccountDao;
import entity.Account;

/**
 * IAccountDao 实现类
 *
 */
@Repository("accountDaoSpringImpl")
public class AccountDaoSpringImpl implements IAccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Account find(int id) {
		
		return jdbcTemplate.queryForObject(
				"select * from account where id=?",											//-- sql
				new Object[] {id}, 							//-- 参数
				new BeanPropertyRowMapper<>(Account.class) //--转化规则
				);
	}

	@Override
	public void saveOrUpdate(Account act) {
		if(act.getId() == 0) {
			jdbcTemplate.update(
					"insert into account(name,balance) values(?,?)",
					new Object[] {act.getName(),act.getBalance()}
					);
		}else {
			jdbcTemplate.update(
					"update account set name=?,balance=? where id=?",
					new Object[] {act.getName(),act.getBalance(),act.getId()}
					);
		}
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update(
				"delete from account where id=?",
				new Object[] {id});
	}

	@Override
	public List<Account> findAll() {
		return null;
	}
	@Override
	public List<Account> find(int offset, int pageSize) {
		return jdbcTemplate.query(
				"select * from account limit ?,?", 
				new Object[]{offset,pageSize}, 
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public int totalItem() {
		return 0;
	}

}
