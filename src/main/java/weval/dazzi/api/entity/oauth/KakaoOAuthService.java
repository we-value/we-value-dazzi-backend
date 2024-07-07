package weval.dazzi.api.entity.oauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weval.dazzi.api.entity.oauth.dto.RequestOauth;
import weval.dazzi.api.entity.oauth.dto.ResponseOauth;

import java.util.Map;

@Service
public class KakaoOAuthService {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirectUri;

    public String getKakaoToken(RequestOauth.OauthV1 oauthV1) {
        RestTemplate restTemplate = new RestTemplate();
        String tokenUri = "https://kauth.kakao.com/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> request = new HttpEntity<>(String.format(
                "grant_type=authorization_code&client_id=%s&redirect_uri=%s&code=%s&client_secret=%s",
                clientId, redirectUri, oauthV1.getCode(), clientSecret), headers);

        ResponseEntity<Map> response = restTemplate.exchange(tokenUri, HttpMethod.POST, request, Map.class);

        return (String) response.getBody().get("access_token");
    }

    public ResponseOauth.UserInfo getUserInfo(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        String userInfoUri = "https://kapi.kakao.com/v2/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ResponseOauth.UserInfo> response = restTemplate.exchange(userInfoUri, HttpMethod.GET, entity, ResponseOauth.UserInfo.class);

        return response.getBody();
    }
}
