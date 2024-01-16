package org.example.hacking02_sk.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("account")
@Data
public class Account {
    int myacc;
    String myid;
    int mymoney;
    String mybank;
    int myaccpw;
}
