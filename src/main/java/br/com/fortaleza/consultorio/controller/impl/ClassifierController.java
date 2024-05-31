package br.com.fortaleza.consultorio.controller.impl;

import br.com.fortaleza.consultorio.controller.IClassifierController;
import br.com.fortaleza.consultorio.dto.ClassifierDTO;
import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.service.IClassifierService;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/classifier")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ClassifierController implements IClassifierController {

    private final IClassifierService service;

    @Override
    public ResponseEntity<ClassifierDTO> findById(String id) throws NotFoundException, BadRequestException {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Override
    public ResponseEntity<Page<ClassifierDTO>> list(String value, String type, Pageable pageable) throws BusinessException {
        ClassifierDTO dto = ClassifierDTO.builder()
                .value(value)
                .type(type)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(service.list(dto, pageable));
    }

    @Override
    public ResponseEntity<ClassifierDTO> saveOrUpdate(ClassifierDTO dto) throws BusinessException, SQLIntegrityConstraintViolationException {
        return ResponseEntity.status(HttpStatus.OK).body(service.saveOrUpdate(dto));
    }

    @Override
    public ResponseEntity<Void> delete(String id) throws BusinessException, BadRequestException, NotFoundException {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
