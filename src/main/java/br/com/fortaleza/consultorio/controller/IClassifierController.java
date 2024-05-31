package br.com.fortaleza.consultorio.controller;

import br.com.fortaleza.consultorio.dto.ClassifierDTO;

import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLIntegrityConstraintViolationException;

@Validated
public interface IClassifierController {

    @RequestMapping(value = "/findById/{id}", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<ClassifierDTO> findById(@PathVariable("id") String id) throws NotFoundException, BadRequestException;

    @RequestMapping(value = "/list", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<Page<ClassifierDTO>> list(@RequestParam(required = false) String value,
            @RequestParam(required = false) String type,
            @PageableDefault(size = 15, direction = Sort.Direction.ASC, sort = {"type"}) Pageable pageable) throws BusinessException;

    @RequestMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<ClassifierDTO> saveOrUpdate(@Validated @RequestBody() ClassifierDTO dto) throws BusinessException, SQLIntegrityConstraintViolationException;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> delete(@PathVariable("id") String id) throws BusinessException, BadRequestException, NotFoundException;

}
