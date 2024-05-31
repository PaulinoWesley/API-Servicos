package br.com.fortaleza.consultorio.business.impl;

import br.com.fortaleza.consultorio.business.IEndpointBusiness;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.model.EndpointModel;
import br.com.fortaleza.consultorio.repository.read.IEndpointReadRepository;
import br.com.fortaleza.consultorio.repository.write.IEndpointWriteRepository;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EndpointBusiness implements IEndpointBusiness {

    private final IEndpointWriteRepository rwRepository;
    private final IEndpointReadRepository roRepository;

    @Override
    public EndpointModel findByKey(String key) throws NotFoundException {
        return null;
    }

    @Override
    public EndpointModel findById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public Page<EndpointModel> list(EndpointModel model, Pageable pageable) throws BusinessException {
        return null;
    }

    @Override
    public EndpointModel saveOrUpdate(EndpointModel model) throws SQLIntegrityConstraintViolationException, BusinessException {
        return null;
    }

    @Override
    public void delete(UUID id) throws BusinessException, NotFoundException {

    }

}
