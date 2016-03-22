package com.ers.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();;
		ArrayList<ArrayList<SummaryVO>> summaryList = null;
		EmployeeVO empVO  = new EmployeeVO();
		
		String empId = (String)request.getParameter("empId");
		session.setAttribute("empId", empId);
		empVO.setEmpId(Integer.parseInt(empId));
		DisplayActionFactory summaryAction = new SummaryAction();
		summaryList = (ArrayList<ArrayList<SummaryVO>>)summaryAction.getList(empVO);
		request.setAttribute("summaryList", summaryList);
		request.getRequestDispatcher("/summary.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
