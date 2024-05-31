package br.com.fortaleza.consultorio.repository.write.impl;

import br.com.fortaleza.consultorio.model.ClassifierModel;
import br.com.fortaleza.consultorio.repository.write.IClassifierWriteRepository;

import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClassifierWriteRepository implements IClassifierWriteRepository {

    @Override
    public Optional<ClassifierModel> save(ClassifierModel model) throws SQLIntegrityConstraintViolationException {
        return Optional.empty();
    }

    @Override
    public Optional<ClassifierModel> update(ClassifierModel model) throws SQLIntegrityConstraintViolationException {
        return Optional.empty();
    }

    @Override
    public void delete(UUID id) {

    }

}
