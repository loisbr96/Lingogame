package com;

import com.persistence.model.Word;
import com.persistence.model.WordRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(WordRepository wordRepository){
        return args -> {
            wordRepository.save(new Word("test"));
            wordRepository.save(new Word("Effe checken"));
        };
    }

}

//@RestController
//class HelloController {
//    private final GreetingRepository greetingRepository;
//
//    @GetMapping("/")
//    String hello(){
//        return "hello world";
//    }
//
//    @GetMapping("/greetings")
//    Iterable<Greeting> greetings(){
//        return greetingRepository.findAll();
//    }
//
//    HelloController(GreetingRepository greetingRepository){
//        this.greetingRepository = greetingRepository;
//    }
//}

//@Entity
//class Greeting {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @Column
//    private String message;
//
//    public Greeting(){
//
//    }
//
//    public Greeting(String message){
//        this.message = message;
//    }
//
//    public Long getId(){
//        return id;
//    }
//
//    public String getMessage(){
//        return message;
//    }
//
//}

//interface GreetingRepository extends CrudRepository<Greeting, Long>{}
