package br.com.fortaleza.consultorio.repository.write.impl;

import br.com.fortaleza.consultorio.model.EndpointModel;
import br.com.fortaleza.consultorio.repository.write.IEndpointWriteRepository;

import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EndpointWriteRepository implements IEndpointWriteRepository {

    @Override
    public Optional<EndpointModel> save(EndpointModel model) throws SQLIntegrityConstraintViolationException {
        return Optional.empty();
    }

    @Override
    public Optional<EndpointModel> update(EndpointModel model) throws SQLIntegrityConstraintViolationException {
        return Optional.empty();
    }

    @Override
    public void delete(UUID id) {

    }

}
