package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import entity.Review;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Review r = new Review();
		ReviewDao dao = new ReviewDao();
		
		String name = request.getParameter("edit");
		
		r = dao.searchByName(name);
		request.setAttribute("edit", r);		
		RequestDispatcher rd = request.getRequestDispatcher("./edit.jsp");
		rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReviewDao dao = new ReviewDao();
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String reason = request.getParameter("reason");
		
		int star = 0;
		if(request.getParameter("star") != null) {
			star = Integer.parseInt(request.getParameter("star"));
		}
			
	    String error = "--";
	        
	    if (star == 0) {
	        error += "『評価』";
	    }
	    if (title.length() == 0) {
	        error += "『レビュータイトル』";
	    }
	    if (reason.length() == 0) {
	        error += "『レビュー』";
	    }
		
		
	    if (error == "--") { // エラーがないとき
	    	int result = dao.updateReviewByName(title, reason, star, name);
		
	    	if(result == 1) {
	    		request.setAttribute("message", "レビューが更新されました");
	    		
	    	}else {
	    		request.setAttribute("message", "レビュー更新に失敗しました");
	    		
	    	}
	    }else {
	    	error = error + "を入力してください。";
            request.setAttribute("error", error);
            
            Review r = new Review();
    		r.setName(name);
    		r.setTitle(title);
    		r.setReason(reason);
    		r.setStar(star);
            request.setAttribute("edit", r);
            RequestDispatcher rd = request.getRequestDispatcher("./edit.jsp");
            rd.forward(request, response);
	    }
	    
	    RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
		rd.forward(request, response); 
	}
}
