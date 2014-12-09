import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Swap extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board = null;
		board = request.getParameter("board");
		int size = Integer.parseInt(request.getParameter("size"));
		int move = Integer.parseInt(request.getParameter("move"));
		String newBoard = Util.swap(board, size, move);
		if (newBoard != null) {
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.write(newBoard);
			out.flush();
			out.close();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
	}

}
