package servises;

import dto.UserDto;
import models.Subj;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.stream.Collectors;

public class SubjServiceImpl implements SubjService {

    private JdbcTemplate jdbcTemplate;

    public SubjServiceImpl(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //language=SQL
    private static final String SQL_SELECT_ALL_BY_TITLE =
            "select * from subj where lower(title) like lower(?)";

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
    public List<Subj> findAllByTitle(String name) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_TITLE, subjRowMapper, name);
    }
}
