package context;

import lombok.SneakyThrows;
import models.Subj;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.*;
import servises.UsersService;
import servises.UsersServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UsersServiceListener implements ServletContextListener {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/films";

    @Override
    @SneakyThrows
    public void contextInitialized(ServletContextEvent sce) {
        Class.forName("org.postgresql.Driver");
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        UsersRepository usersRepository = new UsersRepositoryImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);
        SubjRepository subjRepository = new SubjRepositoryImpl(dataSource);
        HistoryRepository historyRepository = new HistoryRepositoryImpl(dataSource);


        ServletContext context = sce.getServletContext();
        context.setAttribute("usersService", usersService);
        context.setAttribute("usersRepository", usersRepository);
        context.setAttribute("subjRepository", subjRepository);
        context.setAttribute("historyRepository", historyRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}