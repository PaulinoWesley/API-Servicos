package br.com.fortaleza.consultorio.controller.impl;

import br.com.fortaleza.consultorio.controller.IEndpointController;
import br.com.fortaleza.consultorio.dto.EndpointDTO;
import br.com.fortaleza.consultorio.service.IEndpointService;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/endpoint")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class EndpointController implements IEndpointController {

    private final IEndpointService service;

    @Override
    public ResponseEntity<EndpointDTO> findById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<EndpointDTO>> list(String key, String url, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<EndpointDTO> saveOrUpdate(EndpointDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return null;
    }

}
