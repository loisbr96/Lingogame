package com.services;

import com.persistence.WordRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WordServiceUnitTest {
    private WordRepository wordRepository;

    @Before
    public void setUp(){
        this.wordRepository = new WordRepositoryStub();
    }

    @Test
    public void addWord() throws Exception {
        WordService wordService = new WordService(wordRepository);

        Word word = wordService.addWord("testen");
        assertThat(word.getWord()).isEqualTo("testen");
    }

    @Test(expected = Exception.class)
    public void addSpecialWord() throws Exception{
        WordService wordService = new WordService(wordRepository);

        Word word = wordService.addWord("*sdf+r");
        assertThat(word.getWord()).isEqualTo("*sdf+r");
    }

    @Test(expected = Exception.class)
    public void addToLongWord() throws Exception{
        WordService wordService = new WordService(wordRepository);

        Word word = wordService.addWord("eenlangwoord");
        assertThat(word.getWord()).isEqualTo("eenlangwoord");
    }

    @Test(expected = Exception.class)
    public void addToShortWord() throws Exception{
        WordService wordService = new WordService(wordRepository);

        Word word = wordService.addWord("hoi");
        assertThat(word.getWord()).isEqualTo("hoi");
    }

    @Test
    public void getRandomWord() throws Exception {
        WordService wordService = new WordService(wordRepository);
        assertThat(wordService.getRandomWord()).isOfAnyClassIn(Word.class);
    }

    @Test
    public void feedbackCorrectWord(){
        Game game = new Game();
        game.setWord(new Word("testen"));

        Word testWord = new Word("testen");

        WordService wordService = new WordService(wordRepository);
        wordService.feedbackWord(game, testWord);

        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i < testWord.getWord().length(); i++) {
            char c = testWord.getWord().charAt(i);

            JSONObject jsonObjectChar = new JSONObject();
            jsonObjectChar.put("char", c);
            jsonObjectChar.put("position", i);
            jsonObjectChar.put("state", "correct");

            jsonArray.appendElement(jsonObjectChar);
        }
        assertThat(jsonArray).isEqualTo(wordService.feedbackWord(game, testWord));
    }

    @Test
    public void feedbackWrongWord(){
        Game game = new Game();
        game.setWord(new Word("testen"));

        Word testWord = new Word("laptop");

        WordService wordService = new WordService(wordRepository);
        wordService.feedbackWord(game, testWord);

        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i < testWord.getWord().length(); i++) {
            char c = testWord.getWord().charAt(i);

            JSONObject jsonObjectChar = new JSONObject();
            jsonObjectChar.put("char", c);
            jsonObjectChar.put("position", i);

            switch (i) {
                case 0:
                    jsonObjectChar.put("state", "wrong");
                    break;
                case 1:
                    jsonObjectChar.put("state", "wrong");
                    break;
                case 2:
                    jsonObjectChar.put("state", "wrong");
                    break;
                case 3:
                    jsonObjectChar.put("state", "correct");
                    break;
                case 4:
                    jsonObjectChar.put("state", "wrong");
                    break;
                case 5:
                    jsonObjectChar.put("state", "wrong");
                    break;
            }
            jsonArray.appendElement(jsonObjectChar);
        }
        assertThat(jsonArray).isEqualTo(wordService.feedbackWord(game, testWord));
    }
}
