package com.memo.memo.domain.memo;

import com.memo.memo.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "memos")
public class Memo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "checked", nullable = false)
    private boolean checked = Boolean.FALSE;    // 처리 체크 여부

    @Builder
    public Memo(String content, boolean checked) {
        if (ObjectUtils.isEmpty(content)) throw new IllegalArgumentException("할일 내용을 적어주세요");
        if (ObjectUtils.isEmpty(checked)) throw new IllegalArgumentException("처리 여부를 체크해주세요");
        this.content = content;
        this.checked = checked;
    }

    public void update(MemoDto.MemoRequest memoDto) {
        this.content = memoDto.getContent();
        this.checked = memoDto.isChecked();
    }

    public MemoDto.MemoResponse toResponse() {
        return MemoDto.MemoResponse.builder()
                .id(id)
                .content(content)
                .createDateTime(this.getCreateAt())
                .build();
    }
}
