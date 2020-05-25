package com.persistence;


import com.persistence.WordRepository;
import com.persistence.model.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WordRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WordRepository wordRepository;

    @Test
    public void addCorrectWord(){
        Word testWord = new Word("teste");
        entityManager.persist(testWord);
        entityManager.flush();

        Word wordSave = wordRepository.save(testWord);
    }

    @Test
    public void addWordSpecial(){
        Word testWord = new Word("a-b-c-d");
        return ;
    }




}
