package br.com.fortaleza.consultorio.controller;

import br.com.fortaleza.consultorio.dto.EndpointDTO;

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

@Validated
public interface IEndpointController {

    @RequestMapping(value = "/findById/{id}", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<EndpointDTO> findById(@PathVariable("id") String id);

    @RequestMapping(value = "/list", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<Page<EndpointDTO>> list(@RequestParam(required = false) String key,
            @RequestParam(required = false) String url,
            @PageableDefault(size = 25, direction = Sort.Direction.ASC, sort = {"key"}) Pageable pageable);

    @RequestMapping(value = "/", produces = {"application/json"}, consumes = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<EndpointDTO> saveOrUpdate(@Validated @RequestBody EndpointDTO dto);

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> delete(@PathVariable("id") String id);

}
