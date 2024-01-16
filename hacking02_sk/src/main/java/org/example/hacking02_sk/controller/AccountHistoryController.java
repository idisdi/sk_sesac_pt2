package org.example.hacking02_sk.controller;

import org.example.hacking02_sk.mapper.AccountHistoryMapper;
import org.example.hacking02_sk.mapper.AccountMapper;
import org.example.hacking02_sk.model.Account;
import org.example.hacking02_sk.model.AccountHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("acchistory")
public class AccountHistoryController {
    @Autowired
    AccountHistoryMapper accountHistoryMapper;
    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("index")
    String accountHistoryList(Model model, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date myaccdate,
                              @RequestParam(required = false) String myaccmemo){
        List<Account> accountList = accountMapper.list();
        List<AccountHistory> accountHistoryList = accountHistoryMapper.list(myaccdate, myaccmemo);

        System.out.println("test account history w/ param"+accountHistoryList);

        System.out.println(accountList); // [Account(myacc=1012345678, myid=user1, mymoney=1000000, mybank=sk, myaccpw=1234), Account(myacc=1012345679, myid=user2, mymoney=500000, mybank=sesac, myaccpw=4321)]
        System.out.println(accountHistoryList); // [AccountHistory(myacchistnum=1, myacc=1012345678, myaccdate=Tue Jan 16 11:24:20 KST 2024, myaccin=6000, myaccout=0, myaccbalance=100000, myaccioname=hjl, myaccmemo=coffee), AccountHistory(myacchistnum=2, myacc=1012345678, myaccdate=Tue Jan 16 11:24:20 KST 2024, myaccin=0, myaccout=12000, myaccbalance=88000, myaccioname=hjl, myaccmemo=lunch), AccountHistory(myacchistnum=3, myacc=1012345678, myaccdate=Tue Jan 16 11:24:20 KST 2024, myaccin=5000, myaccout=0, myaccbalance=93000, myaccioname=hjl, myaccmemo=bet)]

        model.addAttribute("list", accountHistoryMapper.list(myaccdate, myaccmemo));

        // 1. 현재 로그인 계정 id 가져옴 ex) myid = 'user1'
        // TODO: 구현
        String user = "user1";

        // 2. id에 해당하는 거래 내역 정보 로드
        String myaccForUser = accountList.stream()
                .filter(account -> user.equals(account.getMyid()))
                .map(account -> String.valueOf(account.getMyacc())) // Convert Integer to String
                .findFirst()
                .orElse(null);  // Specify a default value or handle the case where no match is found
        System.out.println("myacc for the signed-in user: " + myaccForUser); // myacc for user1: 1012345678

        List<AccountHistory> myacchistoryForUser = accountHistoryList
                .stream()
                .filter(history -> myaccForUser.equals(String.valueOf(history.getMyacc())))
                .collect(Collectors.toList());

        model.addAttribute("list", myacchistoryForUser);

        System.out.println("The Account History for the signed-in user : " + myacchistoryForUser);
        
        // 3. 검색 필터에 따라 일부 정보만 리로드
        // 필터 1. 날짜
        // 필터 2. 메모

        return "acchistory/index";
    }
}
