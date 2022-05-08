package com.memo.memo.domain.memo;

import com.memo.memo.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "memos")
public class Memo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "checked", nullable = false, columnDefinition = "default false")
    private boolean checked;    // 할일 체크 여부

}
