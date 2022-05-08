package com.memo.memo.domain.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MemoController {
    public String memoListPage() {
        return "index";
    }
}
