package br.com.fortaleza.consultorio.repository.write.impl;

import br.com.fortaleza.consultorio.model.ParameterModel;
import br.com.fortaleza.consultorio.repository.write.IParameterWriteRepository;

import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ParameterWriteRepository implements IParameterWriteRepository {

    @Override
    public Optional<ParameterModel> save(ParameterModel model) throws SQLIntegrityConstraintViolationException {
        return Optional.empty();
    }

    @Override
    public Optional<ParameterModel> update(ParameterModel model) throws SQLIntegrityConstraintViolationException {
        return Optional.empty();
    }

    @Override
    public void delete(UUID id) {

    }

}
