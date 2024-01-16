package org.example.hacking02_sk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.hacking02_sk.model.Account;

import java.util.List;

@Mapper
public interface AccountMapper {
    List<Account> list();
}
