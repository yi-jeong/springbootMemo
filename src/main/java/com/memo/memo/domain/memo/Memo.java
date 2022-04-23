package com.memo.memo.domain.memo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

public class Memo {

    private Long serial;

    private String content;

    private Date createDate;

    private Boolean check;


    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }


//    @Builder
//    public Memo(String content, Date datailTime ){
//        this.content = content;
//        this.datailTime = datailTime;
//        this.check = false;
//    }

}
