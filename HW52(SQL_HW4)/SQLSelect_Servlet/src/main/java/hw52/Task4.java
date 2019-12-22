package hw52;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Task4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter p = resp.getWriter();
        DBConnection connection = new DBConnection();
        p.println("<a href='../' style='margin:10px'>Назад</a>");
        p.println(connection.connect("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies where release_year = year(now())-1"));
    }
}
