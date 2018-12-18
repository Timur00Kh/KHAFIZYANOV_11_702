package repositories;

import models.User;
import org.springframework.dao.EmptyResultDataAccessException;
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
            "select * from film_user where id = ? LIMIT 1";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "select * from film_user where name = ? LIMIT 1";

    //language=SQL
    private static final String SQL_SELECT_BY_SESSION =
            "select * from film_user where session_id = ? LIMIT 1";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into film_user(name, session_id, hashpassword) values (?, ?, ?);";

    //language=SQL
    private static final String SQL_UPDATE =
            "update film_user set name= ?, hashpassword = ?, session_id = ?, is_admin= ?, avatar_url = ? where id = ?;";


    //language=SQL
    private static final String SQL_UPDATE_SESSION =
            "update film_user set session_id = ? where name = ?;";

    //language=SQL
    private static final String SQL_UPDATE_AVATAR =
            "update film_user set avatar_url = ? where id = ?;";



    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (resultSet, i) -> {
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .session_id(resultSet.getString("session_id"))
                .hashPassword(resultSet.getString("hashpassword"))
                .avatarUrl(resultSet.getString("avatar_url"))
                .build();
    };

    @Override
    public Optional<User> findOne(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id));
    }

    @Override
    public User save(User model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_INSERT, new String[] {"id"});
                    ps.setString(1, model.getName());
                    ps.setString(2, model.getSession_id());
                    ps.setString(3, model.getHashPassword());
                    return ps;
                }, keyHolder);
        if (keyHolder.getKey() != null) model.setId(keyHolder.getKey().longValue());
        return model;
    }

    public Optional<User> findOneByName(String name) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, userRowMapper, name));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findOneBySession(String session) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_SESSION, userRowMapper, session));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_UPDATE);
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getHashPassword());
                    ps.setString(3, user.getSession_id());
                    ps.setBoolean(4, user.getIsAdmin());
                    ps.setString(5, user.getAvatarUrl());
                    ps.setLong(6, user.getId());
                    return ps;
                });
    }

    //TODO dep updateSession
    public void updateSession(String name, String session) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_UPDATE_SESSION);
                    ps.setString(1, session);
                    ps.setString(2, name);
                    return ps;
                });
    }

    //TODO dep updateAvatar
    public void updateAvatar(Long id, String avatar) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_UPDATE_AVATAR);
                    ps.setString(1, avatar);
                    ps.setLong(2, id);
                    return ps;
                });
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
