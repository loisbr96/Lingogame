package com;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(GreetingRepository greetingRepository){
        return args -> {
            greetingRepository.save(new Greeting("HELLO LOIS"));
            greetingRepository.save(new Greeting("De test werkt"));
        };
    }

}

@RestController
class HelloController {
    private final GreetingRepository greetingRepository;

    @GetMapping("/")
    String hello(){
        return "hello world";
    }

    @GetMapping("/greetings")
    Iterable<Greeting> greetings(){
        return greetingRepository.findAll();
    }

    HelloController(GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }
}

@Entity
class Greeting {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String message;

    public Greeting(){

    }

    public Greeting(String message){
        this.message = message;
    }

    public Long getId(){
        return id;
    }

    public String getMessage(){
        return message;
    }

}

interface GreetingRepository extends CrudRepository<Greeting, Long>{}
