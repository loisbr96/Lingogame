package com.persistence;

import com.persistence.model.Word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
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
    public void findAll(){
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("testen"));
        words.add(new Word("hallo"));
        words.add(new Word("laptop"));
        words.add(new Word("nogiets"));

        for(Word word: words){
            entityManager.persist(word);
            entityManager.flush();
        }
        Iterable<Word> found = wordRepository.findAll();
        List<Word> allWords = new ArrayList<>();
        found.forEach(allWords::add);

        assertThat(allWords.size() == 10);
    }

    @Test(expected = ConstraintViolationException.class)
    public void addToLongWord(){
        Word testWord = new Word("testtesten");
        entityManager.persist(testWord);
        entityManager.flush();
        assertThat(wordRepository.save(testWord));
    }

    @Test(expected = ConstraintViolationException.class)
    public void addToShortWord(){
        Word testWord = new Word("test");
        entityManager.persist(testWord);
        entityManager.flush();
        assertThat(wordRepository.save(testWord));
    }

    @Test(expected = ConstraintViolationException.class)
    public void addSpecialWord(){
        Word testWord = new Word("te*s-t");
        entityManager.persist(testWord);
        entityManager.flush();
        assertThat(wordRepository.save(testWord));
    }

}
