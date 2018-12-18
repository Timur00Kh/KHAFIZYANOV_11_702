package filter;

import models.User;
import repositories.UsersRepository;
import servises.UsersService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter("*")
public class AuthFilter implements Filter {

    private UsersService usersService;
    private UsersRepository usersRepository;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        usersService = (UsersService)context.getAttribute("usersService");
        usersRepository = (UsersRepository)context.getAttribute("usersRepository");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Optional<User> user = Optional.empty();

        if (request.getCookies() != null)
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("auth")) {
                user = usersRepository.findOneBySession(cookie.getValue());
            }
        }

        request.setAttribute("user", user);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
