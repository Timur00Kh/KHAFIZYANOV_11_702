package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.JavaConfig;
import models.HistoryPart;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.HistoryRepository;
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
import java.util.List;
import java.util.Optional;

@WebServlet("/history")
public class getHistory extends HttpServlet {
    private UsersService usersService;
    private HistoryRepository historyRepository;
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(JavaConfig.class);
        historyRepository = (HistoryRepository) context.getBean("historyRepository");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Long limit = Long.getLong(request.getParameter("limit"));
//        Long offset = Long.getLong(request.getParameter("offset"));

        String limit = (request.getParameter("limit"));
        String offset = (request.getParameter("offset"));

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        try {
            List<HistoryPart> historyPartList = historyRepository.findAll(Long.parseLong(limit), Long.parseLong(offset));

            writer.write(objectMapper.writeValueAsString(historyPartList));

        } catch (IllegalArgumentException e) {
            writer.println("{\"status\":\"ERR\", \"desc\":\"" + e.getMessage() + "\"}");
        }


    }
}
