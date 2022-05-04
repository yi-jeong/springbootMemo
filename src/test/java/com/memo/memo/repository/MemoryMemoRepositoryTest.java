package com.memo.memo.repository;

import com.memo.memo.domain.memo.Memo;
import com.memo.memo.repository.memo.MemoRepository;
import com.memo.memo.repository.memo.MemoryMemoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemoRepositoryTest {

    MemoryMemoRepository repository = new MemoryMemoRepository();

    @AfterEach
    public void afterEach(){
        repository.clearMap();
    }

    @Test
    public void save(){
        Memo memo = new Memo();
        Date now = new Date();
        memo.setContent("hi");

        repository.save(memo);

        Memo result = repository.findBySerial(memo.getSerial()).get();
        assertThat(memo).isEqualTo(result);
    }

    @Test
    public void findByContent(){
        Memo memo1 = new Memo();
        memo1.setContent("hi");
        repository.save(memo1);

        Memo memo2 = new Memo();
        memo2.setContent("hi222");
        repository.save(memo2);

        Memo result = repository.findByContent("hi").get();
        assertThat(result).isEqualTo(memo1);
    }

    @Test
    public void findAll(){
        Memo memo1= new Memo();
        Date now = new Date();
        memo1.setContent("hi");

        repository.save(memo1);

        Memo memo2= new Memo();
        memo2.setContent("hi222");

        repository.save(memo2);

        List<Memo> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}
