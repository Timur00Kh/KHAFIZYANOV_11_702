package context;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.*;
import servises.SubjService;
import servises.SubjServiceImpl;
import servises.UsersService;
import servises.UsersServiceImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class JavaConfig {

    @Value("${db.username}")
    private String USERNAME; //final don't work

    @Value("${db.password}")
    private String PASSWORD;

    @Value("${db.url}")
    private String URL;

    @Bean
    @Scope(value = "singleton")
    @SneakyThrows
    public DriverManagerDataSource dataSource() {
        Class.forName("org.postgresql.Driver");
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Bean
    public UsersRepository usersRepository() {
        return new UsersRepositoryImpl(dataSource());
    }

    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersRepository());
    }

    @Bean
    public SubjRepository subjRepository() {
        return new SubjRepositoryImpl(dataSource());
    }

    @Bean
    public HistoryRepository historyRepository() {
        return new HistoryRepositoryImpl(dataSource());
    }

    @Bean
    public SubjService subjService() {
        return new SubjServiceImpl(dataSource());
    }

}
