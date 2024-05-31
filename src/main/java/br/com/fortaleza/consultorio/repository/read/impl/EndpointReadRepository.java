package br.com.fortaleza.consultorio.repository.read.impl;

import br.com.fortaleza.consultorio.model.EndpointModel;
import br.com.fortaleza.consultorio.repository.read.IEndpointReadRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class EndpointReadRepository implements IEndpointReadRepository {

    @Override
    public Optional<EndpointModel> findByKey(String key) {
        return Optional.empty();
    }

    @Override
    public Optional<EndpointModel> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Page<EndpointModel> list(EndpointModel model, Pageable pageable) {
        return null;
    }

}
