package com.memo.memo.service.memo;

import com.memo.memo.domain.memo.Memo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoServiceTest {

    private MemoService memoService;

    @Test
    void create() {
        // given
        Memo memo = new Memo();
        Date now = new Date();
        memo.setContent("hi");


        // when
        Long memoSerial = memoService.Create(memo);

        // then
        Memo findMemo = memoService.findOne(memoSerial).get();
        assertThat(memo.getContent()).isEqualTo(findMemo.getContent());
    }

    @Test
    void findMemo() {
    }

    @Test
    void findByDate() {
    }
}