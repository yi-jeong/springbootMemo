package com.memo.memo.service.memo;

import com.memo.memo.domain.memo.Memo;
import com.memo.memo.repository.memo.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    // 01. 추가
    public Long Create(Memo memo){
        memoRepository.save(memo);
        return memo.getSerial();
    }

    // 02. 조회
    public List<Memo> findMemo(){
        return memoRepository.findAll();
    }

    public Optional<Memo> findByDate(Date createDate){
        return memoRepository.findByDate(createDate);
    }

    public Optional<Memo> findOne(Long memoSerial){
        return memoRepository.findBySerial(memoSerial);
    }

    // 03. 수정

    // 04. 삭제

}
