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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		String name = request.getParameter("delete");
		
		System.out.println(name);
		
		r = dao.searchByName(name);
		request.setAttribute("delete", r);		
		RequestDispatcher rd = request.getRequestDispatcher("./delete.jsp");
		rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReviewDao dao = new ReviewDao();
		
		String name = request.getParameter("delete2");
		
		int result = dao.deleteByName(name);
		
		if(result == 1) {
			request.setAttribute("message", "レビューが削除されました");
		}else {
			request.setAttribute("message", "レビュー削除に失敗しました");
		}	
		
		RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
		rd.forward(request, response); 
	}

}
