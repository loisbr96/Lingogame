package com;

import com.persistence.WordRepository;
import com.persistence.model.Word;
import com.web.controller.WordController;
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
            wordRepository.save(new Word("eerste woord"));
            wordRepository.save(new Word("tweede woord"));



        };
    }
}
