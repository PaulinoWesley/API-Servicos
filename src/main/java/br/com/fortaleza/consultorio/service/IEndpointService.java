package br.com.fortaleza.consultorio.service;

import br.com.fortaleza.consultorio.dto.EndpointDTO;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.model.EndpointModel;

import java.util.Optional;

public interface IEndpointService extends IBaseService<EndpointModel, EndpointDTO> {
    Optional<EndpointModel> findByKey(String key) throws NotFoundException;
}
