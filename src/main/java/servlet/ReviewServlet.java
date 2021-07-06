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
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher rd = request.getRequestDispatcher("./review.jsp");
         rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String reason = request.getParameter("reason");
		
		int star = 0;
		if(request.getParameter("star") != null) {
			star = Integer.parseInt(request.getParameter("star"));
		}
		
		Review r = new Review();
		r.setName(name);
		r.setTitle(title);
		r.setReason(reason);
		r.setStar(star);
		
		String error = "--";
		if (name.length() == 0) {
            error += "『題名』";
        }
        if (star == 0) {
            error += "『評価』";
        }
        if (title.length() == 0) {
            error += "『レビュータイトル』";
        }
        if (reason.length() == 0) {
            error += "『レビュー』";
        }
		
        if (error == "--") {
        	ReviewDao dao = new ReviewDao();
        	int result = dao.insert(r);
        	if(result == 1) {
        		request.setAttribute("message", "レビューが追加されました");
        	}else {
        		request.setAttribute("message", "レビュー追加に失敗しました");
        	}
        	RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
        	rd.forward(request, response); 
        }else {
        	error = error + "を入力してください。";
            request.setAttribute("error", error);
            request.setAttribute("review", r);
            RequestDispatcher rd = request.getRequestDispatcher("./review.jsp");
            rd.forward(request, response);
        }
	}

}
