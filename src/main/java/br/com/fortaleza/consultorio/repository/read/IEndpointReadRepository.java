package br.com.fortaleza.consultorio.repository.read;

import br.com.fortaleza.consultorio.model.EndpointModel;

import java.util.Optional;

public interface IEndpointReadRepository extends IBaseReadRepository<EndpointModel> {
    Optional<EndpointModel> findByKey(String key);
}
