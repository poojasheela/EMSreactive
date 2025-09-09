package com.example.ems_reactive.controller;

import com.example.ems_reactive.response.Response;
import com.example.ems_reactive.service.impl.GithubActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ems/github")
@RequiredArgsConstructor
@Slf4j
public class GithubActionController {
    private final GithubActionService githubActionService;
    @PostMapping("/trigger-workflow")
    public Mono<ResponseEntity<Response>> triggerGithubWorkflow() {
        return githubActionService.triggerWorkflow()
                .map(response -> ResponseEntity.status(response.getStatus()).body(response));
    }
}
