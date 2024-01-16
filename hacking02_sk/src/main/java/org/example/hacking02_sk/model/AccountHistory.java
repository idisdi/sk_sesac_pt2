package org.example.hacking02_sk.model;

import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("acchistory")
@Data
public class AccountHistory {
    private int myacchistnum;
    private int myacc;
    private Date myaccdate;

    private int myaccin;

    private int myaccout;

    private int myaccbalance;
    private String myaccioname;
    private String myaccmemo;
}
