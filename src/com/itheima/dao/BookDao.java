package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Book;

public interface BookDao {

	void save(Book book);
	/**
	 * 把书籍对应的分类也查询出来
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
	/**
	 * 获取书籍的总记录数
	 * @return
	 */
	int getTotalRecordsNum();
	/**
	 * 分页查询:还要把书籍对应的分类查询出来
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List findPageRecords(int startIndex, int pageSize);
	int getTotalRecordsNum(String categoryId);
	List findPageRecords(int startIndex, int pageSize, String categoryId);

}
