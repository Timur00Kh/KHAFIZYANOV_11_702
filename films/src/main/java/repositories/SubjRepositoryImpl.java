package repositories;

import models.Subj;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class SubjRepositoryImpl implements SubjRepository {

    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "select * from subj where id = ? LIMIT 1";

    //language=SQL
    private static final String SQL_SELECT_BY_TITLE =
            "select * from subj where title = ? LIMIT 1";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into subj(title, type, genre, duration, release_date, status, poster_url, \"desc\", release_year) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    //language=SQL
    private static final String SQL_GET_ALL =
            "select * from subj where deleted != true";

    //language=SQL
    private static final String SQL_UPDATE_AVATAR =
            "update film_user set avatar_url = ? where id = ?;";

    //language=SQL
    private static final String SQL_UPDATE =
            "update subj set title = ?, type = ?, genre = ?, duration = ?, release_date = ?, status = ?, poster_url = ?, \"desc\" = ?, release_year = ? where id = ?;";



    private JdbcTemplate jdbcTemplate;


    public SubjRepositoryImpl(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private RowMapper<Subj> subjRowMapper = (resultSet, i) -> {
        return Subj.builder()
                .id(Long.parseLong(resultSet.getString("id")))
                .title(resultSet.getString("title"))
                .type(resultSet.getString("type"))
                .genre(resultSet.getString("genre"))
                .duration(resultSet.getString("duration"))
                .releaseDate(resultSet.getString("release_date"))
                .status(resultSet.getString("status"))
                .posterUrl(resultSet.getString("poster_url"))
                .desc(resultSet.getString("desc"))
                .releaseYear(resultSet.getInt("release_year"))
                .build();
    };


    @Override
    public Optional<Subj> findOneByName(String name) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_TITLE, subjRowMapper, name));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Subj> findOneById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, subjRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Subj> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Subj save(Subj model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_INSERT, new String[] {"id"});
                    ps.setString(1, model.getTitle());
                    ps.setString(2, model.getType());
                    ps.setString(3, model.getGenre());
                    ps.setString(4, model.getDuration());
                    ps.setString(5, model.getReleaseDate());
                    ps.setString(6, model.getStatus());
                    ps.setString(7, model.getPosterUrl());
                    ps.setString(8, model.getDesc());
                    ps.setInt(9, model.getReleaseYear());
                    return ps;
                }, keyHolder);
        if (keyHolder.getKey() != null) model.setId(keyHolder.getKey().longValue());
        return model;
//         title, type, genre, duration, releaseDate, status, posterUrl, desc
    }

    @Override
    public void update(Subj model) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_UPDATE);
                    ps.setString(1, model.getTitle());
                    ps.setString(2, model.getType());
                    ps.setString(3, model.getGenre());
                    ps.setString(4, model.getDuration());
                    ps.setString(5, model.getReleaseDate());
                    ps.setString(6, model.getStatus());
                    ps.setString(7, model.getPosterUrl());
                    ps.setString(8, model.getDesc());
                    ps.setInt(9, model.getReleaseYear());
                    ps.setLong(10, model.getId());
                    return ps;
                });
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Subj> findAll() {
        return jdbcTemplate.query(SQL_GET_ALL, subjRowMapper);
    }
}
