package com.example.demo;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.internalServerError;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {
  
  private final SomeRepository repository;
   
  public MyController(SomeRepository repository) {
    this.repository = repository;
  }
  
  @GetMapping("/200")
  public Mono<ResponseEntity<Map>> response200() {
      return  repository.getStuff().map(payload -> ok(payload));
  }
  
  @GetMapping("/custom")
  public Mono<ResponseEntity<Map>> response400() {
      return  repository.getStuffMyCustomException().map(payload -> badRequest().build());
  }
  
  @GetMapping("/404")
  public Mono<ResponseEntity<Map>> response404() {
      return  repository.getStuff404().map(payload -> notFound().build());
  }
  
  @GetMapping("/500")
  public Mono<ResponseEntity<Map>> response500() {
      return  repository.getStuff500().map(payload -> internalServerError().build());
  }
  
}
