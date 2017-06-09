package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.domain.User;

public interface PrivilegeDao {

	User find(String username, String password);

	List<Role> findRolesByUser(User user);

	List<Function> findFunctionsByRole(Role role);

}
