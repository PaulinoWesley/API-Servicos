package br.com.fortaleza.consultorio.service.impl;

import br.com.fortaleza.consultorio.business.IClassifierBusiness;
import br.com.fortaleza.consultorio.dto.ClassifierDTO;
import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.factory.ClassifierFactory;
import br.com.fortaleza.consultorio.model.ClassifierModel;
import br.com.fortaleza.consultorio.service.IClassifierService;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ClassifierService implements IClassifierService {

    private final IClassifierBusiness business;
    private final ClassifierFactory factory;

    @Override
    public ClassifierDTO findById(String id) throws NotFoundException, BadRequestException {
        ClassifierModel resp = business.findById(id);

        return factory.toDTO(resp);
    }

    @Override
    public Page<ClassifierDTO> list(ClassifierDTO dto, Pageable pageable) throws BusinessException {
        ClassifierModel model = factory.toModel(dto);

        return factory.toPageDTO(business.list(model, pageable));
    }

    @Override
    public ClassifierDTO saveOrUpdate(ClassifierDTO dto) throws BusinessException, SQLIntegrityConstraintViolationException {
        ClassifierModel model = factory.toModel(dto);

        return factory.toDTO(business.saveOrUpdate(model));
    }

    @Override
    public void delete(String id) throws BadRequestException, BusinessException, NotFoundException {
        business.delete(UUID.fromString(id));
    }

}
