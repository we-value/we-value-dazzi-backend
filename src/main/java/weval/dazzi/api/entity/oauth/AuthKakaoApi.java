package weval.dazzi.api.entity.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weval.dazzi.api.config.config.security.jwt.JwtTokenProvider;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth2")
public class AuthKakaoApi {

    private final JwtTokenProvider jwtTokenProvider;

    private final KakaoOAuthService kakaoOAuthService;

    @PostMapping("/kakao")
    public Map<String, String> loginWithKakao(@RequestBody Map<String, String> body) {
        String code = body.get("code");

        Map<String, Object> tokenResponse = kakaoOAuthService.getKakaoToken(code);
        String accessToken = (String) tokenResponse.get("access_token");

        Map<String, Object> userInfo = kakaoOAuthService.getUserInfo(accessToken);
        String userId = userInfo.get("id").toString();

        String token = jwtTokenProvider.createToken(userId);

        return Map.of("token", token);
    }
}
