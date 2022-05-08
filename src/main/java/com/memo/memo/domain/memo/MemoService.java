package com.memo.memo.domain.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository jpaMemoRepository;

    // 메모 저장
    public void createMemo(Memo memo){
        jpaMemoRepository.save(memo);
    }

    // 메모 조회(일단위 groupBy, createdDate asc)
    public void getMemoList(LocalDate date) {
        List<Memo> memos = jpaMemoRepository.findByDate(date);
    }

    // 메모 할일 변경
    public void updateMemoCheck(Memo memo) {
        Memo targetMemo = jpaMemoRepository.getById(memo.getSerial());
        // 수정한거 정의
        // targetMemo.setChecked();

        // 갱신
        jpaMemoRepository.save(targetMemo);
    }

    // 메모 삭제
    public void deleteMemo(Long serial) {
        jpaMemoRepository.deleteById(serial);
    }

}
