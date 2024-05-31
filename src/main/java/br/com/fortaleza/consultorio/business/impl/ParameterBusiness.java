package br.com.fortaleza.consultorio.business.impl;

import br.com.fortaleza.consultorio.business.IParameterBusiness;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.model.ParameterModel;
import br.com.fortaleza.consultorio.repository.read.IParameterReadRepository;
import br.com.fortaleza.consultorio.repository.write.IParameterWriteRepository;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ParameterBusiness implements IParameterBusiness {

    private final IParameterWriteRepository rwRepository;
    private final IParameterReadRepository roRepository;

    @Override
    public ParameterModel findByName(String name) throws NotFoundException {
        return null;
    }

    @Override
    public ParameterModel findById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public Page<ParameterModel> list(ParameterModel model, Pageable pageable) throws BusinessException {
        return null;
    }

    @Override
    public ParameterModel saveOrUpdate(ParameterModel model) throws SQLIntegrityConstraintViolationException, BusinessException {
        return null;
    }

    @Override
    public void delete(UUID id) throws BusinessException, NotFoundException {

    }

}
