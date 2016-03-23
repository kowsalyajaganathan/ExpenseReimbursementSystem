package com.ers.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.valueobject.EmployeeVO;
import com.ers.valueobject.SummaryVO;
import com.ers.workflow.DisplayActionFactory;
import com.ers.workflow.SummaryAction;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try{
			HttpSession session = request.getSession();		
			ArrayList<ArrayList<SummaryVO>> summaryList = null;
			EmployeeVO employeeVO  = new EmployeeVO();			
			String empId = (String)request.getParameter("empId");
			session.setAttribute("empId", empId);
			employeeVO.setEmpId(Integer.parseInt(empId));
			DisplayActionFactory summaryAction = new SummaryAction();
			summaryList = (ArrayList<ArrayList<SummaryVO>>)summaryAction.getList(employeeVO);
			logger.debug("summary list size"+summaryList.size());
			request.setAttribute("summaryList", summaryList);
			request.getRequestDispatcher("/summary.jsp").forward(request, response);
		}catch(ServletException e){
			logger.error("Exception"+e.getStackTrace());
		}catch(IOException e){
			logger.error("Exception"+e.getStackTrace());
		}
	}	
}
