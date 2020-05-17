package com;

import com.persistence.model.Word;
import com.services.WordService;
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
    ApplicationRunner applicationRunner(WordService wordService){
        return args -> {
            wordService.addWord(new Word("eerste woord"));
            wordService.addWord(new Word("tweede woord"));

        };
    }
}
