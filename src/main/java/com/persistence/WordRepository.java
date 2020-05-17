package com.persistence;

import com.persistence.model.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WordRepository extends CrudRepository<Word, Long> {
    Optional<Word> findById(Word id);
}
