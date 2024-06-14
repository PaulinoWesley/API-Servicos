package br.com.fortaleza.consultorio.repository.read.impl;

import br.com.fortaleza.consultorio.mapper.ClassifierMapper;
import br.com.fortaleza.consultorio.model.ClassifierModel;
import br.com.fortaleza.consultorio.repository.read.IClassifierReadRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClassifierReadRepository implements IClassifierReadRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ClassifierReadRepository(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<ClassifierModel> findByType(String type) {
        return Optional.empty();
    }

    @Override
    public Optional<ClassifierModel> findById(UUID id) {
        String select;
        select = "SELECT c.ID, c.VALUE, c.TYPE ";
        select += "FROM " + ClassifierModel.getTableName() + " c ";
        select += "WHERE c.ID = :id";

        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);

        ResultSetExtractor<List<ClassifierModel>> mapper = new ClassifierMapper();

        List<ClassifierModel> resp = this.jdbcTemplate.query(select, parameter, mapper);
        if (resp != null && !resp.isEmpty())
            return Optional.ofNullable(resp.get(0));

        return Optional.empty();
    }

    @Override
    public Page<ClassifierModel> list(ClassifierModel model, Pageable pageable) {
        return null;
    }

}
