package servlets;

import context.JavaConfig;
import forms.LoginForm;
import forms.SignUpForm;
import models.HistoryPart;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.HistoryRepository;
import repositories.UsersRepository;
import repositories.UsersRepositoryImpl;
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


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;
    private UsersRepository usersRepository;
    private HistoryRepository historyRepository;



    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(JavaConfig.class);
        usersService = (UsersService)context.getBean("usersService");
        usersRepository = (UsersRepository)context.getBean("usersRepository");
        historyRepository = (HistoryRepository) context.getBean("historyRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ftl/signUp.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");

        Optional<User> user = usersRepository.findOneByName(email);
        if (user.isPresent()) {
            writer.println("{\"status\":\"ERR\", \"desc\":\"The name is already taken\"}");
            return;
        }


        if (password.equals(password2)) {
            String uuid = UUID.randomUUID().toString();
            SignUpForm signUpForm = SignUpForm.builder()
                    .name(email)
                    .password(password)
                    .password2(password2)
                    .uuid(uuid)
                    .build();

            usersService.signUp(signUpForm);
            Cookie cookie = new Cookie("auth", uuid);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            writer.println("{\"status\":\"OK\", \"uuid\":\"" + uuid +  "\"}");
            HistoryPart historyPart = HistoryPart.builder()
                    .actionTitle(user.get().getName() + " has born.")
                    .user(user.get())
                    .build();

            historyRepository.save(historyPart);
        } else {
            writer.println("{\"status\":\"ERR\", \"desc\":\"Incorrect password\"}");
        }
    }


}
