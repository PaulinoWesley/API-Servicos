package br.com.fortaleza.consultorio.repository.read.impl;

import br.com.fortaleza.consultorio.model.ParameterModel;
import br.com.fortaleza.consultorio.repository.read.IParameterReadRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ParameterReadRepository implements IParameterReadRepository {

    @Override
    public Optional<ParameterModel> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<ParameterModel> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Page<ParameterModel> list(ParameterModel model, Pageable pageable) {
        return null;
    }

}
