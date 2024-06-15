package br.com.fortaleza.consultorio.repository.read.impl;

import br.com.fortaleza.consultorio.mapper.ClassifierMapper;
import br.com.fortaleza.consultorio.model.ClassifierModel;
import br.com.fortaleza.consultorio.repository.read.IClassifierReadRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class ClassifierReadRepository implements IClassifierReadRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<ClassifierModel> findByType(String type) {
        String select;
        select = "SELECT c.id, c.value, c.type ";
        select += "FROM " + ClassifierModel.getTableName() + " c ";
        select += "WHERE c.type = :type";

        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("type", type);

        ResultSetExtractor<List<ClassifierModel>> mapper = new ClassifierMapper();

        List<ClassifierModel> resp = this.jdbcTemplate.query(select, parameter, mapper);
        if (resp != null && !resp.isEmpty())
            return Optional.ofNullable(resp.get(0));

        return Optional.empty();
    }

    @Override
    public Optional<ClassifierModel> findById(UUID id) {
        String select;
        select = "SELECT c.id, c.value, c.type ";
        select += "FROM " + ClassifierModel.getTableName() + " c ";
        select += "WHERE c.id = :id";

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
        String select;
        String clausuleAnd = "";

        select = "SELECT c.id, c.value, c.type ";
        select += "FROM " + ClassifierModel.getTableName() + " c ";
        if (model.getType() != null || model.getValue() != null) {
            List<String> filter = new ArrayList<>();

            if (model.getType() != null)
                filter.add(" c.type ILIKE %" + model.getType() + "% ");
            if (model.getValue() != null)
                filter.add(" c.value ILIKE %" + model.getValue() + "% ");

            clausuleAnd = String.join("AND", filter);

            if (!filter.isEmpty())
                select += "WHERE" + clausuleAnd;
        }
        Sort.Order order = pageable.getSort().toList().get(0);
        select += String.format("ORDER BY %s %s ", order.getProperty(), order.getDirection());
        select += String.format("LIMIT %s ", pageable.getPageSize());
        select += String.format("OFFSET %s", pageable.getOffset());

        ResultSetExtractor<List<ClassifierModel>> mapper = new ClassifierMapper();
        List<ClassifierModel> classifierList = this.jdbcTemplate.query(select, mapper);

        if (classifierList != null && !classifierList.isEmpty()) {
            String selectCount = "SELECT count(1) as row_count FROM "
                    + ClassifierModel.getTableName() + " c " + clausuleAnd;

            Long totalElements = this.jdbcTemplate.query(selectCount, (rs, rowNum) -> rs.getLong(1)).get(0);

            return new PageImpl<>(classifierList, pageable, totalElements);
        }

        return new PageImpl<>(new ArrayList<>(), pageable, 0);
    }

}
