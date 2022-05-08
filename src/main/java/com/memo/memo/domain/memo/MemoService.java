package com.memo.memo.domain.memo;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoService {

    private final static Sort MEMO_SORT = Sort.by(Sort.Direction.ASC, "created_at");

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Transactional(readOnly = true)
    public void getMemoList() {
        List<Memo> memoList = memoRepository.findAll(MEMO_SORT);
        // 메모가 빈경우
        if (ObjectUtils.isEmpty(memoList)) {
            return;
        }


        List<MemoDto.MemoResponse> memoResponses =  memoList.stream()
                .map(Memo::toResponse)
                .collect(Collectors.toList());
    }

    public void addMemo(MemoDto.MemoRequest memoDto) {
        Memo memo = memoDto.toEntity();
        memoRepository.save(memo);
    }

    public void modifyMemo(Long id, MemoDto.MemoRequest memoDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException(String.format("%d번 메모가 존재하지 않습니다", id));
        });

        memo.update(memoDto);

        memoRepository.save(memo);
    }

    public void removeMemo(Long id) {
        memoRepository.deleteById(id);
    }


}
