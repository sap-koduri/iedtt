package in.iedtt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.DefectCommentDao;
import in.iedtt.entity.DefectComment;
import in.iedtt.entity.Response;
import in.iedtt.util.Mail;

public class NewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DefectComment comment = new DefectComment();
		DefectCommentDao commentDao = new DefectCommentDao();
		String commentor = (request.getSession() !=null)? (String) request.getSession().getAttribute("userId"):"";
		comment.setCommentor(commentor);
		String commentMsg = request.getParameter("comment");
		comment.setComment(commentMsg);
		 String defect = (String)request.getParameter("defectId");
		int defectId = (defect != null)?Integer.valueOf(defect):0;
		comment.setDefectId(defectId);
		comment.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		Response logCommentResponse = commentDao.logComment(comment);
		request.setAttribute("logCommentResponse", logCommentResponse);
		String identifiedBy = (String)request.getParameter("identifiedBy_comment");
		Mail.sendNotification(comment.getCommentor()+"," + identifiedBy, "Comment added to Defect ID : "+comment.getDefectId(),comment.getComment());
		List<DefectComment> commentsByDefectId = commentDao.getCommentsByDefectId(defectId);
		request.getSession().setAttribute("commentsByDefectId", commentsByDefectId);
		request.getRequestDispatcher("./editDefect.jsp").forward(request, response);
	}

}
