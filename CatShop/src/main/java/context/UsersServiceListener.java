package context;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.UsersRepository;
import repositories.UsersRepositoryImpl;
import servises.UsersService;
import servises.UsersServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class UsersServiceListener implements ServletContextListener {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/cat_shop";

    @Override
    @SneakyThrows
    public void contextInitialized(ServletContextEvent sce) {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        UsersRepository usersRepository = new UsersRepositoryImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);
        ServletContext context = sce.getServletContext();
        context.setAttribute("usersService", usersService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}