package servlet;

import post.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns ="/edit", name="edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        if (!"".equals(id)) {
            PostRepository.getInstance().edit(Integer.parseInt(id), title, author, content);
        }
        resp.sendRedirect(getServletContext().getContextPath());
    }
}
