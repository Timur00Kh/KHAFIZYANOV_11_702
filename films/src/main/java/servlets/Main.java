package servlets;

import context.JavaConfig;
import lombok.SneakyThrows;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.UsersRepository;
import repositories.UsersRepositoryImpl;
import servises.UsersService;
import servises.UsersServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet({"/main", ""})
public class Main extends HttpServlet {
    private UsersService usersService;
    private UsersRepository usersRepository;

    @Override
    @SneakyThrows
    public void init(ServletConfig config) throws ServletException {

        ApplicationContext context = new
                AnnotationConfigApplicationContext(JavaConfig.class);
        usersService = (UsersService) context.getBean("usersService");
        usersRepository = (UsersRepository) context.getBean("usersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ftl/main.ftl").forward(request, response);
    }
}
