package com.example.ems_reactive.service.impl;

import com.example.ems_reactive.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class GithubActionServiceImpl implements GithubActionService {
    private final WebClient webClient; // Inject WebClient bean
    @Value("${github.api.token}")
    private String githubToken;
    @Value("${github.repo.workflow_url}")
    private String workflowUrl;
    @Override
    public Mono<Response> triggerWorkflow() {
        return webClient.post()
                .uri(workflowUrl)
                .header("Authorization", "Bearer " + githubToken)
                .retrieve()
                .bodyToMono(String.class)
                .map(result -> Response.success("Workflow triggered successfully", result))
                .onErrorResume(ex -> Mono.just(Response.error("Failed to trigger workflow", 500, ex.getMessage())));
    }
}
