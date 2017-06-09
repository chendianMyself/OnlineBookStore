package com.itheima.service;

import java.util.List;

import com.itheima.commons.Page;
import com.itheima.domain.Book;
import com.itheima.domain.Category;
import com.itheima.domain.Customer;
import com.itheima.domain.Function;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Role;
import com.itheima.domain.User;

public interface BusinessService {
	/**
	 * 添加分类
	 * @param c
	 */
	void addCategory(Category c);
	/**
	 * 查询所有的分类
	 * @return
	 */
	List<Category> findAllCategories();
	/**
	 * 根据id查询分类
	 * @param categoryId
	 * @return 没有找到返回null
	 */
	Category findCategoryById(String categoryId);
	/**
	 * 添加书籍
	 * @param book
	 * 如果book关联的Category为null，要抛出参数错误异常
	 */
	void addBook(Book book);
	/**
	 * 根据id查询一本书
	 * @param bookId
	 * @return book，还有分类
	 */
	Book findBookById(String bookId);
	/**
	 * 根据用户要查看的页码，返回封装了所有与分页有关的Page对象
	 * @param num 要看的页码，如果为null或“”，默认为1
	 * @return
	 */
	Page findBookPageRecords(String num);
	Page findBookPageRecords(String num, String categoryId);
	/**
	 * 添加客户
	 * @param c
	 */
	void addCustomer(Customer c);
	/**
	 * 根据主键查询客户
	 * @param customerId
	 * @return
	 */
	Customer findCustomer(String customerId);
	/**
	 * 客户登录
	 * @param username
	 * @param password
	 * @return
	 */
	Customer customerLogin(String username,String password);
	/**
	 * 生成订单。订单中必须有订单项；必须有关联的客户信息
	 * @param o
	 * 
	 */
	void genOrder(Order o);
	/**
	 * 根据订单号查询订单
	 * @param ordernum
	 * @return
	 */
	Order findOrderByNum(String ordernum);
	/**
	 * 查询客户的订单
	 * @param c
	 */
	List<Order> findCustomerOrders(Customer c);
	/**
	 * 更改订单状态
	 * @param order
	 */
	void changeOrderStatus(Order order);
	/**
	 * 后台：用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username,String password);
	/**
	 * 查询用户拥有的所有角色
	 * @param user
	 * @return
	 */
	List<Role> findRolesByUser(User user);
	/**
	 * 根据角色查询对应的功能
	 * @param role
	 * @return
	 */
	List<Function> findFunctionsByRole(Role role);
	
}
