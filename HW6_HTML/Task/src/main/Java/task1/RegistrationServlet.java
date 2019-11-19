package task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegistrationServlet extends HttpServlet {
    private Users users;

    public RegistrationServlet() {
        this.users = new Users();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        if(gender == null) {
            gender = "male";
        }
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String subscribe = req.getParameter("subscribe");
        if(subscribe == null){
            subscribe = "off";
        }
        PrintWriter writer = resp.getWriter();
        users.add(login, password, gender, phone, email, subscribe);
        Path path = Paths.get(".\\users.txt");
        File file = new File(".\\users.txt");
        if (!file.exists()) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
        writer.println("<p>Add new user!" +
                "</p><p>Login: " + login +
                "</p><p>Password: " + password +
                "</p><p>Gender: " + gender +
                "</p><p>Phone: " + phone +
                "</p><p>Email: " + email +
                "</p><p>Subscribe: " + subscribe + "</p>");
        writer.println("<a href=\"index.html\">Back</a>");
    }
}