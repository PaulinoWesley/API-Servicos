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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLIntegrityConstraintViolationException;

@Validated
public interface IClassifierController {

    @GetMapping(value = "/findById/{id}", produces = {"application/json"})
    ResponseEntity<ClassifierDTO> findById(@PathVariable("id") String id) throws NotFoundException, BadRequestException;

    @GetMapping(value = "/list", produces = {"application/json"})
    ResponseEntity<Page<ClassifierDTO>> list(@RequestParam(required = false) String value,
            @RequestParam(required = false) String type,
            @PageableDefault(size = 15, direction = Sort.Direction.ASC, sort = {"type"}) Pageable pageable) throws BusinessException;

    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<ClassifierDTO> saveOrUpdate(@Validated @RequestBody() ClassifierDTO dto) throws BusinessException, SQLIntegrityConstraintViolationException;

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) throws BusinessException, BadRequestException, NotFoundException;

}
