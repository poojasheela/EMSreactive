package com.example.ems_reactive.service;

import com.example.ems_reactive.dto.DepartmentDTO;
import com.example.ems_reactive.response.Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface DepartmentService {
    Mono<Response> create(DepartmentDTO dto);
    Mono<Response> update(String id, DepartmentDTO dto);
    Mono<Response> delete(String id);
    Flux<DepartmentDTO> getAll();
    Mono<Response> getById(String id);
    Mono<Response> getByName(Optional<String> name);
}