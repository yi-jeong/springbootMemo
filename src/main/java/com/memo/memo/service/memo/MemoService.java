package com.memo.memo.service.memo;

import com.memo.memo.domain.memo.Memo;
import com.memo.memo.repository.memo.JpaMemoRepository;
import com.memo.memo.repository.memo.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final JpaMemoRepository jpaMemoRepository;

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
