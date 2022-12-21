package com.example.demo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Repository
public class SomeHardcodedRepository implements SomeRepository{
  
  @CircuitBreaker(name = "my-service")
  public Mono<Map> getStuff() {
    return Mono.just(Map.of("key", "stuff"));
  }

  @CircuitBreaker(name = "my-service")
  public Mono<Map> getStuffMyCustomException() {
    return Mono.error(new MyCustomException());
  }
  
  @CircuitBreaker(name = "my-service")
  public Mono<Map> getStuff404() {
    return Mono.error(WebClientResponseException.create(404, "404", new HttpHeaders(), null, null));
  }

  @CircuitBreaker(name = "my-service")
  public Mono<Map> getStuff500() {
    return Mono.error(WebClientResponseException.create(500, "500", new HttpHeaders(), null, null));
  }
  
  
}
