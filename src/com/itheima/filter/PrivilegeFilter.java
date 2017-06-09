package com.itheima.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;
//只拦截后台资源的访问
public class PrivilegeFilter implements Filter {
	private BusinessService s = new BusinessServiceImpl();
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request;
		HttpServletResponse response;
		request = (HttpServletRequest)req;
		response = (HttpServletResponse)res;
	/*	try{
	 
		}catch(Exception e){
			throw new RuntimeException("no-http request or response");
		}
		
		//检查用户是否登录
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//没有登录：转向登陆页面
		if(user==null){
			request.getRequestDispatcher("/passport/adminlogin.jsp").forward(request, response);
			return;
		}
		//登录：
			//把当前登录用户能访问的功能存起来：Set<Function>
			Set<Function> funs = new HashSet<Function>();
			//查询对应的角色
			List<Role> roles = s.findRolesByUser(user);
			//遍历角色：查询功能
			for(Role r:roles){
				List<Function> functions = s.findFunctionsByRole(r);
				funs.addAll(functions);
			}
			//得到用户当前访问的uri地址
			String uri = request.getRequestURI();//  /day23_01_netstore/manage/addCategory.jsp
												// /day23_01_netstore/manage/ManageServlet?op=showAllCategory
			String queryString = request.getQueryString();
			if(queryString!=null){
				uri = uri+"?"+queryString;
			}
			uri = uri.replace(request.getContextPath(), "");// /manage/addCategory.jsp?op=xxx
			
			boolean hasPermission = false;//是否有权限
			//对比是否在权限方位之内：
			for(Function f:funs){
				if(uri.equals(f.getUri())){
					hasPermission = true;
					break;
				}
			}
				//不在：提示没权限
			if(!hasPermission){
				response.getWriter().write("您没有权限");
				return;
			}
			*/
		//放行
		chain.doFilter(request, response);	
		
	}

	public void destroy() {

	}

}
