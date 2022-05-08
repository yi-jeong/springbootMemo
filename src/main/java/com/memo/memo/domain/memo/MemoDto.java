package com.memo.memo.domain.memo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemoDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemoRequest {
        private String content;
        private boolean checked;

        public Memo toEntity() {
            return Memo.builder()
                    .content(content)
                    .checked(checked)
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemoResponse {
        private Long id;
        private String content;
        private boolean checked;
        private LocalDate createDate;   // 생성일자
        private LocalDateTime createDateTime; // 생성일자(+시간)

        @Builder
        public MemoResponse(Long id,
                            String content,
                            boolean checked,
                            LocalDateTime createDateTime) {
            this.id = id;
            this.content = content;
            this.checked = checked;
            this.createDateTime = createDateTime;
            this.createDate = createDateTime.toLocalDate();
        }

    }
}
