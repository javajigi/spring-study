package com.blogcode.member;

import com.blogcode.domain.Member;
import com.blogcode.repository.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jojoldu@gmail.com on 2017. 2. 17.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@RestController
public class MemberController {
    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @GetMapping("/")
    public Member get() {
        return new Member("jojoldu", "jojoldu@gmail.com", "");
    }
}
