package org.example.hacking02_sk.controller;

import org.example.hacking02_sk.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountMapper accountMapper;

// 계좌(account)는 따로 view 필요 없음.
//    @RequestMapping("list")
//    String boardList(Model model){
//        System.out.println(accountMapper.list());
//        model.addAttribute("list", accountMapper.list());
//        return "board/boardList";
//    }
}
