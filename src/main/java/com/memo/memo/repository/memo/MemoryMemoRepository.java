package com.memo.memo.repository.memo;

import com.memo.memo.domain.memo.Memo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.*;

@Repository
public class MemoryMemoRepository implements MemoRepository {

    private static Map<Long, Memo> map = new HashMap<>();
    private static long sequence = 01;

    @Override
    public Memo save(Memo memo) {
        memo.setSerial(++sequence);
        map.put(memo.getSerial(), memo);
        return memo;
    }

    @Override
    public Optional<Memo> findBySerial(Long serial) {
        return Optional.ofNullable(map.get(serial));
    }

    @Override
    public Optional<Memo> findByDate(Date createDate) {
        return map.values().stream()
                .filter( memo -> memo.getCreateAt().equals(createDate))
                .findAny();
    }

    @Override
    public Optional<Memo> findByContent(String content) {
        return map.values().stream()
                .filter( memo -> memo.getContent().equals(content))
                .findAny();
    }

    @Override
    public List<Memo> findAll() {
        return new ArrayList<>(map.values());
    }


    public void clearMap(){
        map.clear();
    }
}

