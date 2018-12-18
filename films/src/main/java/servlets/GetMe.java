package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.JavaConfig;
import forms.LoginForm;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.UsersRepository;
import servises.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.UUID;

@WebServlet("/getMe")
public class GetMe extends HttpServlet {

    private UsersService usersService;
    private UsersRepository usersRepository;
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(JavaConfig.class);
        usersService = (UsersService) context.getBean("usersService");
        usersRepository = (UsersRepository) context.getBean("usersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        try {
            Optional<User> user = usersRepository.findOneBySession(uuid);
            if (user.isPresent()) {
                writer.write(objectMapper.writeValueAsString(user.get()));
            } else {
                writer.println("null");
            }
        } catch (IllegalArgumentException e) {
            writer.println("{\"status\":\"ERR\", \"desc\":\"" + e.getMessage() + "\"}");
        }
    }
}