package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.JavaConfig;
import models.HistoryPart;
import models.Subj;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.HistoryRepository;
import repositories.SubjRepository;
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

@WebServlet("/addSubj")
public class AddSubj extends HttpServlet {

    private UsersService usersService;
    private UsersRepository usersRepository;
    private HistoryRepository historyRepository;
    private SubjRepository subjRepository;

    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void init(ServletConfig config) throws ServletException {
       /* ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
        usersRepository = (UsersRepository) context.getAttribute("usersRepository");
        subjRepository = (SubjRepository) context.getAttribute("subjRepository");
        historyRepository = (HistoryRepository) context.getAttribute("historyRepository");*/

        ApplicationContext context = new
                AnnotationConfigApplicationContext(JavaConfig.class);

        usersService = (UsersService) context.getBean("usersService");
        usersRepository = (UsersRepository) context.getBean("usersRepository");
        subjRepository = (SubjRepository) context.getBean("subjRepository");
        historyRepository = (HistoryRepository) context.getBean("historyRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ftl/addSubj.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<User> user = (Optional<User>) request.getAttribute("user");
        PrintWriter writer = response.getWriter();

        if (!user.isPresent()) {
            writer.println("Пожалуйста для начала зарегистрируйтесь");
            return;
        }

        Subj subj = Subj.builder()
                .title(request.getParameter("title"))
                .type(request.getParameter("type"))
                .genre(request.getParameter("genre"))
                .duration(request.getParameter("duration"))
                .releaseDate(request.getParameter("release_date"))
                .releaseYear(Integer.valueOf(request.getParameter("release_year")))
                .status(request.getParameter("status"))
                .posterUrl(request.getParameter("posterUrl"))
                .desc(request.getParameter("desc"))
                .build();


        try {
            subj = subjRepository.save(subj);

            HistoryPart historyPart = HistoryPart.builder()
                    .actionTitle(user.get().getName() + " добавил фильм " + subj.getTitle())
                    .user(user.get())
                    .subj_id(subj.getId())
                    .build();

            historyRepository.save(historyPart);
            writer.write("OK");


        } catch (IllegalArgumentException e) {
            writer.println("{\"status\":\"ERR\", \"desc\":\"" + e.getMessage() + "\"}");
        }


    }
}