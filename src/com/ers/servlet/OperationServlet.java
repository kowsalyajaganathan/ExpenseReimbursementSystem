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

import com.ers.reimbursementForm.ReimbursementFormFactory;
import com.ers.util.Constants;
import com.ers.valueobject.EmployeeVO;
import com.ers.valueobject.ReimbursementVO;
import com.ers.valueobject.SummaryVO;
import com.ers.workflow.ApproverAction;
import com.ers.workflow.CRUDActionFactory;
import com.ers.workflow.DisplayActionFactory;
import com.ers.workflow.SubmitterAction;
import com.ers.workflow.SummaryAction;
import com.ers.workflow.ViewDetailsAction;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(OperationServlet.class);
	/**
     * @see HttpServlet#HttpServlet()
     */
    public OperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();;
		ArrayList<ArrayList<SummaryVO>> summaryList = null;
		ReimbursementVO reimbursementVO = null;
		DisplayActionFactory viewDetailsAction = new ViewDetailsAction();
		ReimbursementFormFactory form ;
		CRUDActionFactory action ;
		SummaryVO summaryVO = null;
		String message=null;
		DisplayActionFactory summaryAction = new SummaryAction();
		
		EmployeeVO empVO  = new EmployeeVO();
		empVO.setEmpId(Integer.parseInt((String)session.getAttribute("empId")));
		
		String submitterView = (String)request.getParameter("submitterView");
		String approverView = (String)request.getParameter("approverView");
		String updateAction = (String)request.getParameter("Update");
		String deleteAction = (String)request.getParameter("Delete");
		String approveAction = (String)request.getParameter("Approve");
		String rejectAction = (String)request.getParameter("Reject");
		String updateSubmitAction = (String)request.getParameter("UpdateSubmit");
		String createAction = (String)request.getParameter("Create");
		String createSubmitAction = (String)request.getParameter("CreateSubmit");
		
		String actionType =null;
		if(submitterView!=null){
			actionType = Constants.ACTION_SUBMITTER_VIEW;
		}else if(approverView!=null){
			actionType = Constants.ACTION_APPROVERVIEW;
		}else if(updateAction!=null){
			actionType = Constants.ACTION_UPDATE;
		}else if(deleteAction!=null){
			actionType = Constants.ACTION_DELETE;
		}else if(approveAction!=null){
			actionType = Constants.ACTION_APPROVE;
		}else if(rejectAction!=null){
			actionType = Constants.ACTION_REJECT;
		}else if(updateSubmitAction!=null){
			actionType = Constants.ACTION_UPDATESUBMIT;
		}else if(createAction!=null){
			actionType = Constants.ACTION_CREATE;
		}else if(createSubmitAction!=null){
			actionType = Constants.ACTION_CREATE;
		}
		request.setAttribute("actionType", actionType);
		logger.debug("action type"+actionType);
				
		if(submitterView !=null || updateAction!=null|| deleteAction !=null){
			summaryVO = (SummaryVO)session.getAttribute("submitterVO");
			if(submitterView!=null ||updateAction!=null){
				reimbursementVO = ((ArrayList<ReimbursementVO> )viewDetailsAction.getList(summaryVO)).get(0);
				logger.debug("reimbursementVO in submitter block"+reimbursementVO.toString());
				request.setAttribute("reimbursementVO", reimbursementVO);
				request.getRequestDispatcher("/action.jsp").forward(request, response);				
			}else if(updateSubmitAction != null  ){	
				action = new SubmitterAction();
				form = ReimbursementFormFactory.getReimbursementForm(summaryVO.getType());
				form.setFormId(summaryVO.getReimbursementId());				
				boolean isSuccess = action.createWorkflowObject(actionType, form,empVO);
				if(isSuccess){
					if(Constants.ACTION_APPROVE.equals(actionType)){
						message = Constants.MSG_APPROVE_SUCCESS;
					}else{
						message = Constants.MSG_REJECT_SUCCESS;
					}
				}else{
					if(Constants.ACTION_APPROVE.equals(actionType)){
						message = Constants.MSG_APPROVE_FAIL;
					}else{
						message = Constants.MSG_REJECT_FAIL;
					}
				}
				summaryList = (ArrayList<ArrayList<SummaryVO>>)summaryAction.getList(empVO);
				request.setAttribute("summaryList", summaryList);					
				request.setAttribute("message", message);
				request.getRequestDispatcher("/summary.jsp").forward(request, response);
			}else{
				action = new SubmitterAction();
				form = ReimbursementFormFactory.getReimbursementForm(summaryVO.getType());
				form.setFormId(summaryVO.getReimbursementId());				
				boolean isSuccess = action.createWorkflowObject(actionType, form,empVO);
				if(isSuccess){
					message = Constants.MSG_DELETE_SUCCESS;
				}else{
					message = Constants.MSG_DELETE_FAIL;
				}

				summaryList = (ArrayList<ArrayList<SummaryVO>>)summaryAction.getList(empVO);
				request.setAttribute("summaryList", summaryList);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/summary.jsp").forward(request, response);	
			}
		}else if (approverView != null || approveAction != null || rejectAction!=null){
			summaryVO = (SummaryVO)session.getAttribute("approverVO");		
		//	if(summaryVO!=null){
			if(approverView!=null){
				reimbursementVO = ((ArrayList<ReimbursementVO> )viewDetailsAction.getList(summaryVO)).get(0);
				request.setAttribute("reimbursementVO", reimbursementVO);
				request.getRequestDispatcher("/action.jsp").forward(request, response);				
			}else{
					action = new ApproverAction();
					form = ReimbursementFormFactory.getReimbursementForm(summaryVO.getType());
					form.setFormId(summaryVO.getReimbursementId());				
					boolean isSuccess = action.createWorkflowObject(actionType, form,empVO);
					if(isSuccess){
						if(Constants.ACTION_APPROVE.equals(actionType)){
							message = Constants.MSG_APPROVE_SUCCESS;
						}else{
							message = Constants.MSG_REJECT_SUCCESS;
						}
					}else{
						if(Constants.ACTION_APPROVE.equals(actionType)){
							message = Constants.MSG_APPROVE_FAIL;
						}else{
							message = Constants.MSG_REJECT_FAIL;
						}
					}
					summaryList = (ArrayList<ArrayList<SummaryVO>>)summaryAction.getList(empVO);
					request.setAttribute("summaryList", summaryList);					
					request.setAttribute("message", message);
					request.getRequestDispatcher("/summary.jsp").forward(request, response);	
			}
		}
	}
}
	
