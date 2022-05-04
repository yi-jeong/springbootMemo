package com.memo.memo.repository.memo;

import com.memo.memo.domain.memo.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaMemoRepository extends JpaRepository<Memo, Long> {
    public List<Memo> findByDate(LocalDate date);
}
