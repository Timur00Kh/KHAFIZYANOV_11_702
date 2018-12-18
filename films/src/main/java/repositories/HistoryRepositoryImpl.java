package repositories;

import models.HistoryPart;
import models.Subj;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class HistoryRepositoryImpl implements HistoryRepository {




    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "select * from film_user where id = ? LIMIT 1";

    //language=SQL
    private static final String SQL_SELECT_ALL_BY_USER =
            "select * from history where user_id = ?;";

    //language=SQL
    private static final String SQL_SELECT_BY_SESSION =
            "select * from film_user where session_id = ? LIMIT 1";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into history(user_id, list_id, subj_id, list_item_id, date, action_title, description) values (?, ?, ?, ?, NOW(), ?, ?);";

    //language=SQL
    private static final String SQL_UPDATE_SESSION =
            "update film_user set session_id = ? where name = ?;";

    //language=SQL
    private static final String SQL_GET_ALL_ORDER_BY_DATE =
            "select * from history ORDER BY date desc LIMIT ? OFFSET ?;";

    private JdbcTemplate jdbcTemplate;

    public HistoryRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<HistoryPart> historyPartRowMapper = (resultSet, i) -> {
        return HistoryPart.builder()
                .id(resultSet.getLong("id"))
                .list_id(resultSet.getLong("list_id"))
                .subj_id(resultSet.getLong("subj_id"))
                .list_item_id(resultSet.getLong("list_item_id"))
                .list_item_id(resultSet.getLong("list_item_id"))
                .creation_date(resultSet.getString("date"))
                .actionTitle(resultSet.getString("action_title"))
                .description(resultSet.getString("description"))
                .build();
    };


    @Override
    public Optional<Subj> findAllByUser(Long id) {
//        jdbcTemplate.query(connection -> {
//            PreparedStatement ps =
//                    connection.prepareStatement(SQL_SELECT_ALL_BY_USER);
//            ps.setString(1, model.getName());
//            ps.setString(2, model.getSession_id());
//            ps.setString(3, model.getHashPassword());
//            return ps;
//        }))
        return Optional.empty();
    }

    @Override
    public Optional<HistoryPart> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public HistoryPart save(HistoryPart model) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_INSERT);
                    ps.setLong(1, model.getUser().getId());

                    if (model.getList_id() != null) {
                        ps.setLong(2, model.getList_id());
                    } else {
                        ps.setNull(2,0);
                    }
                    if (model.getSubj_id() != null) {
                        ps.setLong(3, model.getSubj_id());
                    } else {
                        ps.setNull(3,0);
                    }
                    if (model.getList_item_id() != null) {
                        ps.setLong(4, model.getList_item_id());

                    } else {
                        ps.setNull(4,0);
                    }
                    if (model.getActionTitle() != null) {
                        ps.setString(5, model.getActionTitle());

                    } else {
                        ps.setNull(5,0);
                    }
                    if (model.getDescription() != null) {
                        ps.setString(6, model.getDescription());
                    } else {
                        ps.setNull(6,0);
                    }
                    return ps;
                });
        return null;

//        user_id, list_id, subj_id, list_item_id, date, action_title, description
    }

    @Override
    public void update(HistoryPart model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<HistoryPart> findAll() {
        return null;
    }

    public List<HistoryPart> findAll(long limit, long offset) {
        return jdbcTemplate.query( connection -> {
            PreparedStatement ps =
                    connection.prepareStatement(SQL_GET_ALL_ORDER_BY_DATE);
            ps.setLong(1, limit);
            ps.setLong(2, offset);
            return ps;
        }, historyPartRowMapper);
    }
}
