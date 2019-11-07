package util;

import java.util.List;

/**
 * 封装分页的页数据类
 * 泛型编程
 * @author Administrator
 *
 */
public class Pager<T>{ 
	private List<T> data;   //数据
	private int total;      //总的页数
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
