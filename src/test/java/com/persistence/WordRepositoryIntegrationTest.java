package com.persistence;


import com.persistence.model.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class WordRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WordRepository wordRepository;

    @Test
    public void findById(){
        //Given
        Word word = new Word("testen");
        entityManager.persist(word);
        entityManager.flush();

        //when
        Optional<Word> found = wordRepository.findById(word.getId());

        //then
        assertThat(found.get().getId()).isEqualTo(word.getId());
    }

    @Test
    public void addCorrectWord(){
        Word testWord = new Word("testen");
        entityManager.persist(testWord);
        entityManager.flush();

       assertThat(wordRepository.save(testWord));
    }

//    @Test
//    public void addIncorrectWord(){
//        Word testWord = new Word("a-b-c-d");
//        entityManager.persist(testWord);
//        entityManager.flush();
//
//        assertThat(wordRepository.save(testWord)).
//        return ;
//    }

}
