package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.JavaConfig;
import models.Subj;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.SubjRepository;
import servises.SubjService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/getSubj")
public class getSubj extends HttpServlet {

    private SubjRepository subjRepository;
    private SubjService subjService;
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(JavaConfig.class);
        subjRepository = (SubjRepository) context.getBean("subjRepository");
        subjService = (SubjService) context.getBean("subjService");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");

        if (request.getParameter("id") != null) {
            Optional<Subj> subj = subjRepository.findOneById(Long.getLong(request.getParameter("id")));
            if (subj.isPresent()) {
                writer.write(objectMapper.writeValueAsString(subj));
            } else {
                writer.write("null");
            }
            return;
        }

        if (request.getParameter("name") != null) {
            List<Subj> res = subjService.findAllByTitle("%" + request.getParameter("name") + "%");
//            List<Subj> nres = new ArrayList();
//            for (int i = 0; i < res.size(); i++) {
//                if (res.get(i).getTitle().toLowerCase().contains(request.getParameter("name").toLowerCase())) {
//                    nres.add(res.get(i));
//                }
//            }
            writer.write(objectMapper.writeValueAsString(res));
            return;
        }

        writer.write(objectMapper.writeValueAsString(subjRepository.findAll()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
