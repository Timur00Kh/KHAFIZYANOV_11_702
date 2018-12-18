package repositories;

import lombok.SneakyThrows;
import models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl  implements UsersRepository {

    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "select * from customer where id = ? LIMIT 1";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "select * from customer where name = ? LIMIT 1";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into customer(name, session_id) values (?, ?);";

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (resultSet, i) -> {
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .session_id(resultSet.getLong("session_id"))
                .hashPassword(resultSet.getString("hash_password"))
                .build();
    };

    @Override
    public Optional<User> findOne(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id));
    }

    @Override
    public void save(User model) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_INSERT);
                    ps.setString(1, model.getName());
                    ps.setLong(2, model.getSession_id());
                    return ps;
                });
    }

    public Optional<User> findOneByName(String name) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, userRowMapper, name));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
