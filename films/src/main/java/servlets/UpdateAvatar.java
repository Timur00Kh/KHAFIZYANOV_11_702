package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.JavaConfig;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.UsersRepository;
import servises.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/updateAvatar")
public class UpdateAvatar extends HttpServlet {

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
        Optional<User> user = (Optional<User>) request.getAttribute("user");
        if (!user.isPresent()) return;
        usersRepository.updateAvatar(user.get().getId(), request.getParameter("url"));
        PrintWriter writer = response.getWriter();
        writer.write("OK");
    }
}