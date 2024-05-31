package br.com.fortaleza.consultorio.repository.read.impl;

import br.com.fortaleza.consultorio.model.ClassifierModel;
import br.com.fortaleza.consultorio.repository.read.IClassifierReadRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
        return Optional.empty();
    }

    @Override
    public Page<ClassifierModel> list(ClassifierModel model, Pageable pageable) {
        return null;
    }

}
