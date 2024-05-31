package br.com.fortaleza.consultorio.controller.impl;

import br.com.fortaleza.consultorio.controller.IParameterController;
import br.com.fortaleza.consultorio.dto.ParameterDTO;
import br.com.fortaleza.consultorio.service.IParameterService;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/parameter")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ParameterController implements IParameterController {

    private final IParameterService service;

    @Override
    public ResponseEntity<ParameterDTO> findById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<ParameterDTO>> list(String name, String value, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<ParameterDTO> saveOrUpdate(ParameterDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return null;
    }

}
