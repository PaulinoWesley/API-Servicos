package br.com.fortaleza.consultorio.service.impl;

import br.com.fortaleza.consultorio.business.IEndpointBusiness;
import br.com.fortaleza.consultorio.dto.EndpointDTO;
import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.factory.EndpointFactory;
import br.com.fortaleza.consultorio.model.EndpointModel;
import br.com.fortaleza.consultorio.service.IEndpointService;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EndpointService implements IEndpointService {

    private final IEndpointBusiness business;
    private final EndpointFactory factory;

    @Override
    public Optional<EndpointModel> findByKey(String key) {
        return Optional.empty();
    }

    @Override
    public EndpointDTO findById(String id) throws NotFoundException, BadRequestException {
        return null;
    }

    @Override
    public Page<EndpointDTO> list(EndpointDTO dto, Pageable pageable) throws BusinessException {
        return null;
    }

    @Override
    public EndpointDTO saveOrUpdate(EndpointDTO dto) throws BusinessException, SQLIntegrityConstraintViolationException {
        return null;
    }

    @Override
    public void delete(String id) throws BadRequestException, BusinessException, NotFoundException {

    }

}
