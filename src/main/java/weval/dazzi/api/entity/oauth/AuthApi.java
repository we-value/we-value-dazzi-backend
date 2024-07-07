package weval.dazzi.api.entity.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weval.dazzi.api.config.config.security.jwt.JwtTokenProvider;
import weval.dazzi.api.entity.member.MemberService;
import weval.dazzi.api.entity.oauth.dto.RequestOauth;
import weval.dazzi.api.entity.oauth.dto.ResponseOauth;
import weval.dazzi.domain.entity.member.Member;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class AuthApi {

    private final JwtTokenProvider jwtTokenProvider;

    private final KakaoOAuthService kakaoOAuthService;

    private final MemberService memberService;

    @PostMapping("/kakao")
    public ResponseOauth.TokenAndNickname loginWithKakao(@RequestBody RequestOauth.OauthV1 oauthV1) {
        String accessToken = kakaoOAuthService.getKakaoToken(oauthV1);

        ResponseOauth.UserInfo userInfo = kakaoOAuthService.getUserInfo(accessToken);

        Member member = memberService.checkAndSave(userInfo);

        String token = jwtTokenProvider.createToken(member.getSocialIdAndNickname());

        return new ResponseOauth.TokenAndNickname(token, member.getNickname());
    }
}