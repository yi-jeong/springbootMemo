package com.memo.memo.domain.memo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memos/")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    /**
     * 메모 목록 조회
     * > 조회조건:
     *  - 생성일자(오름차순)
     *  - 일자별로 묶음
     */
    @GetMapping
    public void getMemoList() {
        memoService.getMemoList();
    }

    /**
     * 메모 추가
     */
    @PostMapping
    public void addMemo(@RequestBody MemoDto.MemoRequest memoDto) {
        memoService.addMemo(memoDto);
    }

    /**
     * 메모 수정
     */
    @PutMapping("/{id}")
    public void modifyMemo(@PathVariable("id") Long id,
                           @RequestBody MemoDto.MemoRequest memoDto) {
        memoService.modifyMemo(id, memoDto);
    }

    /**
     * 메모 삭제
     */
    @DeleteMapping("/{id}")
    public void removeMemo(@PathVariable("id") Long id) {
        memoService.removeMemo(id);
    }


}
