package org.example.hacking02_sk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.hacking02_sk.model.AccountHistory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface AccountHistoryMapper {
    List<AccountHistory> list(@Param("myaccdate") String myaccdate, @Param("myaccmemo") String myaccmemo);
}
