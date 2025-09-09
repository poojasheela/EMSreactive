package com.example.ems_reactive.repository;

import com.example.ems_reactive.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

    Flux<Employee> findByContactEmail(String contactEmail);

    Mono<Employee> findByFullName(String fullName);

    Flux<Employee> findAll();
}
