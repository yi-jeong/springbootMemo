package com.memo.memo.domain.memo;

import com.memo.memo.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table( name = "memo" )
public class Memo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "serial" )
    private Long serial;

    @Column( name = "content" )
    private String content;

    @Temporal(TemporalType.TIME)
    @Column( name= "datailTime" )
    private Date datailTime;

    @Column( name = "check" )
    private Boolean check;

    @Builder
    public Memo(String content, Date datailTime ){
        this.content = content;
        this.datailTime = datailTime;
        this.check = false;
    }

}
