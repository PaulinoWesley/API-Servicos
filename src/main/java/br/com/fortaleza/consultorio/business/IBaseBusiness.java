package br.com.fortaleza.consultorio.business;

import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

public interface IBaseBusiness<T> {
    T findById(String id) throws NotFoundException, BadRequestException;
    Page<T> list(T model, Pageable pageable) throws BusinessException;
    T saveOrUpdate(T model) throws SQLIntegrityConstraintViolationException, BusinessException;
    void delete(UUID id) throws BusinessException, NotFoundException;
}
