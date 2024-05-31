package br.com.fortaleza.consultorio.service;

import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLIntegrityConstraintViolationException;

public interface IBaseService<M, D> {
    D findById(String id) throws NotFoundException, BadRequestException;
    Page<D> list(D dto, Pageable pageable) throws BusinessException;
    D saveOrUpdate(D dto) throws BusinessException, SQLIntegrityConstraintViolationException;
    void delete(String id) throws BadRequestException, BusinessException,NotFoundException;
}
