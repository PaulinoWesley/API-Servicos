package br.com.fortaleza.consultorio.repository.read;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBaseReadRepository<T> {
    Optional<T> findById(UUID id);
    Page<T> list(T model, Pageable pageable);
}
