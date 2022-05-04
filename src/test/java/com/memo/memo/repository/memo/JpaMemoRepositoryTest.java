package com.memo.memo.repository.memo;

import com.memo.memo.domain.memo.Memo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@EnableJpaAuditing
public class JpaMemoRepositoryTest {

    @Autowired
    private JpaMemoRepository jpaMemoRepository;

    @DisplayName("메모_저장")
    @Test
    public void memoSaveTest() {
        // given
        Memo memo = givenMemo();

        jpaMemoRepository.save(memo);

        Memo myMemo = jpaMemoRepository.findById(1L).orElse(null);

        Assertions.assertAll(
                () -> Assertions.assertEquals("전이정 똥강아지 ㅋㅋㅋㅋ", myMemo.getContent()),
                () -> Assertions.assertEquals(false, myMemo.isChecked())
        );
    }

    private static Memo givenMemo() {
        Memo memo = new Memo();
        memo.setContent("전이정 똥강아지 ㅋㅋㅋㅋ");
        memo.setChecked(false);
        return memo;
    }

}