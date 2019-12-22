package hw52;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Task5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter p = resp.getWriter();
        DBConnection connection = new DBConnection();
        p.println("<a href='../' style='margin:10px'>Назад</a>");
        p.println(connection.connect("select * from movies.movies join movies.movies_genres  on movies.movie_id = movies_genres.movie_id join movies.genres g on movies_genres.genre_id = g.genre_id where genre_name like 'комедия'"));
    }
}
