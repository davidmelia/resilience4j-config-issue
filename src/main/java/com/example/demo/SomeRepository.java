package com.example.demo;

import java.util.Map;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SomeRepository {

  public Mono<Map> getStuff();
  
  public Mono<Map> getStuffMyCustomException();
  
  public Mono<Map> getStuff404();

  public Mono<Map> getStuff500();
  
}
