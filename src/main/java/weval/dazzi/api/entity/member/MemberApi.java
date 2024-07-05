package weval.dazzi.api.entity.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weval.dazzi.api.entity.member.dto.RequestMember;
import weval.dazzi.domain.member.Member;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @PostMapping
    public Member member(@RequestBody RequestMember.Test test) {
        return memberService.find(test.getId());
    }
}
