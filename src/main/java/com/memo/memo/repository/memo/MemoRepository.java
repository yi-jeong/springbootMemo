package com.memo.memo.repository.memo;

import com.memo.memo.domain.memo.Memo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    Memo save(Memo memo);
    Optional<Memo> findBySerial(Long serial);
    Optional<Memo> findByContent(String content);
    Optional<Memo> findByDate(Date createDate);
    List<Memo> findAll();
}
