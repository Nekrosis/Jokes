package pro.sisit.javacourse.unit7.data.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import pro.sisit.javacourse.unit7.data.JokeDataService;

import java.util.List;

public class JokeDataServiceJdbcImpl implements JokeDataService {
    private final JdbcTemplate jdbcTemplate;

    public JokeDataServiceJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String joke) {
        jdbcTemplate.update("INSERT INTO jokes (joke) VALUES(?)", joke);
    }

    @Override
    public List<String> findAll() {
        return jdbcTemplate.query(" SELECT * FROM jokes", (rs, rowNum) -> rs.getString("joke"));
    }
}
