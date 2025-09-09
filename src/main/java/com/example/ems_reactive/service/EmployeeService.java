package com.example.ems_reactive.service;

import com.example.ems_reactive.dto.EmployeeDTO;
import com.example.ems_reactive.response.Response;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface EmployeeService {

    Mono<Response> create(EmployeeDTO dto);

    Mono<Response> update(String id, EmployeeDTO dto);

    Mono<Response> delete(String id);

    Mono<Response> getById(String id);

    Mono<Response> getByEmail(Optional<String> email);

    Mono<Response> getByName(Optional<String> name);

    Mono<Response> getAll();

    Mono<Response> getPaginated(Optional<Integer> page, Optional<Integer> size);
}

