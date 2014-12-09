import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Shuffle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int N_SHUFFLE = 1000;

	public void init() throws ServletException {
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random random = new Random();
		String board = "";
		int size = Integer.parseInt(request.getParameter("size"));
		for (int i = 0; i < size * size - 1; i++) {
			board += i + 1;
		}
		board += "0";
		for (int i = 0; i < N_SHUFFLE; i++) {
			int r = random.nextInt(size * size);
			board = Util.swap(board, size, r);
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.write(board);
		out.flush();
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
	}

}
