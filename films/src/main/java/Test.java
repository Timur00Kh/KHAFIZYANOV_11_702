import context.JavaConfig;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import repositories.UsersRepository;
import repositories.UsersRepositoryImpl;
import servises.UsersService;
import servises.UsersServiceImpl;

import java.sql.PreparedStatement;

public class Test {

    private static UsersService usersService;
    private static UsersRepository usersRepository;

    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(context.JavaConfig.class);

        usersService = (UsersService) context.getBean("usersService", UsersServiceImpl.class);
        usersRepository = (UsersRepository) context.getBean("usersRepository", UsersRepositoryImpl.class);
        System.out.println(context.getBean("usersRepository", UsersRepositoryImpl.class));
        System.out.println(context.getBean("usersRepository", UsersRepositoryImpl.class));
        System.out.println(context.getBean("usersRepository", UsersRepositoryImpl.class));
        System.out.println(context.getBean("usersRepository", UsersRepositoryImpl.class));
        System.out.println(context.getBean("dataSource"));
        System.out.println(context.getBean("dataSource"));
        System.out.println(context.getBean("dataSource"));
        System.out.println(context.getBean("dataSource"));
        System.out.println(context.getBean("dataSource"));
        int i = 0;

    }
}
