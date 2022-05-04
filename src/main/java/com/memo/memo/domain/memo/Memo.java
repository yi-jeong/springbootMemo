package com.memo.memo.domain.memo;

import com.memo.memo.domain.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "memos")
@ToString
public class Memo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial;

    private String content;

    private boolean checked;

}
