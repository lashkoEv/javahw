package servlet;

import post.PostRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/", name = "home", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", PostRepository.getInstance().getPosts());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
