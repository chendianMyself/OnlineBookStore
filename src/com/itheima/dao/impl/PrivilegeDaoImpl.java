package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.PrivilegeDao;
import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.util.DBCPUtil;

public class PrivilegeDaoImpl implements PrivilegeDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public User find(String username, String password) {
		try {
			return qr.query("select * from users where username=? and password=?", new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Role> findRolesByUser(User user) {
		if(user==null||user.getId()==null){
			throw new IllegalArgumentException("参数不全");
		}
		try {
			//String sql = "select * from roles where id in (select r_id from user_role where u_id=?)"
			return qr.query("select r.* from roles r,user_role ur where r.id=ur.r_id and ur.u_id=?", new BeanListHandler<Role>(Role.class), user.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Function> findFunctionsByRole(Role role) {
		if(role==null||role.getId()==null){
			throw new IllegalArgumentException("参数不全");
		}
		try {
			return qr.query("select f.* from functions f,role_function rf where f.id=rf.f_id and rf.r_id=?", new BeanListHandler<Function>(Function.class), role.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
