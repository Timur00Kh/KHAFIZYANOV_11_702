package servlets;

import context.JavaConfig;
import forms.LoginForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
import java.util.UUID;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(JavaConfig.class);
        usersService = (UsersService)context.getBean("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ftl/signIn.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String uuid = UUID.randomUUID().toString();

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        try {
            LoginForm loginForm = LoginForm.builder()
                    .name(email)
                    .password(password)
                    .uuid(uuid)
                    .build();
            usersService.signIn(loginForm);
            Cookie cookie = new Cookie("auth", uuid);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            writer.println("{\"status\":\"OK\", \"uuid\":\"" + uuid +  "\"}");
        } catch (IllegalArgumentException e) {
            writer.println("{\"status\":\"ERR\", \"desc\":\"" + e.getMessage() + "\"}");
        }




    }
}