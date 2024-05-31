package br.com.fortaleza.consultorio.service.impl;

import br.com.fortaleza.consultorio.business.IParameterBusiness;
import br.com.fortaleza.consultorio.dto.ParameterDTO;
import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.factory.ParameterFactory;
import br.com.fortaleza.consultorio.model.ParameterModel;
import br.com.fortaleza.consultorio.service.IParameterService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
@AllArgsConstructor
public class ParameterService implements IParameterService {

    private final IParameterBusiness business;
    private final ParameterFactory factory;

    @Override
    public ParameterDTO findById(String id) throws NotFoundException, BadRequestException {
        return null;
    }

    @Override
    public Page<ParameterDTO> list(ParameterModel model, Pageable pageable) throws BusinessException {
        return null;
    }

    @Override
    public ParameterDTO saveOrUpdate(ParameterModel model) throws BusinessException, SQLIntegrityConstraintViolationException {
        return null;
    }

    @Override
    public void delete(String id) throws BadRequestException, BusinessException, NotFoundException {

    }

}
