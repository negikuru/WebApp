package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import entity.Review;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        ReviewDao r = new ReviewDao();
        List<Review> rlist = r.showAllList();
        request.setAttribute("rlist",rlist);

		RequestDispatcher rd = request.getRequestDispatcher("./home.jsp");
		rd.forward(request, response); 

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReviewDao r = new ReviewDao();
        List<Review> rlist = r.showAllList();
        request.setAttribute("rlist",rlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("./home.jsp");
		rd.forward(request, response); 
	}
}
