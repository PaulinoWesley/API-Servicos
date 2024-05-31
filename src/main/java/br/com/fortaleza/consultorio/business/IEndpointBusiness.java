package br.com.fortaleza.consultorio.business;

import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.model.EndpointModel;

public interface IEndpointBusiness extends IBaseBusiness<EndpointModel> {
    EndpointModel findByKey(String key) throws NotFoundException;
}
