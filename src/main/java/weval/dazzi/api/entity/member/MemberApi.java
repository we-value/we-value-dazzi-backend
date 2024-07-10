package weval.dazzi.api.entity.member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weval.dazzi.api.entity.member.dto.ResponseMember;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    //제품 등록할때 판매자 있는지 체크
    //판매자 등록할때 판매자 있는지 체크
    @GetMapping("/isSeller")
    public ResponseMember.IsSeller memberIsSeller(HttpServletRequest request) {
        return memberService.memberIsSeller(request.getHeader("authorizationToken"));
    }
}
