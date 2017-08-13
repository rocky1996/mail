package com.cal.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cal.service.UserService;
import com.cal.service.impl.UserServiceImpl;
import com.cal.user.User;
import com.cal.util.WebUtil;
import com.cal.web.bean.UserFormBean;

public class ShowSucServlet extends HttpServlet {
	private UserService s = new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//编码
		request.setCharacterEncoding("UTF-8");
		
		User u = new User();
		
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String essay = request.getParameter("essay"); 
  		
		UserFormBean formbean = new UserFormBean();
		formbean = WebUtil.fillFormBean(UserFormBean.class, request);
		
		if(!formbean.vaildate()){
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/manager/send.jsp").forward(request, response);
			return;
		}
		
		try {
			BeanUtils.copyProperties(u, formbean);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		s.Tosuccess(email, title, essay);
		s.addUser(u);
		
		request.setAttribute("u", "<script type='text/javascript'>alert('发表成功!!!')</script>");
		//response.sendRedirect(request.getContextPath());
		request.getRequestDispatcher("/manager/send.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
