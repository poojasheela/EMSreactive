package com.example.ems_reactive.service.impl;

import com.example.ems_reactive.response.Response;
import reactor.core.publisher.Mono;

public interface GithubActionService {
    Mono<Response> triggerWorkflow();
}
